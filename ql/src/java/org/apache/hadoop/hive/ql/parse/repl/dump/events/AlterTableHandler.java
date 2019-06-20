/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hive.ql.parse.repl.dump.events;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.api.NotificationEvent;
import org.apache.hadoop.hive.metastore.messaging.AlterTableMessage;
import org.apache.hadoop.hive.ql.exec.repl.util.ReplUtils;
import org.apache.hadoop.hive.ql.io.AcidUtils;
import org.apache.hadoop.hive.ql.metadata.Table;
import org.apache.hadoop.hive.ql.parse.EximUtil;

import org.apache.hadoop.hive.ql.parse.repl.DumpType;

import org.apache.hadoop.hive.ql.parse.repl.dump.Utils;
import org.apache.hadoop.hive.ql.parse.repl.load.DumpMetaData;

class AlterTableHandler extends AbstractEventHandler<AlterTableMessage> {
  private final org.apache.hadoop.hive.metastore.api.Table before;
  private final org.apache.hadoop.hive.metastore.api.Table after;
  private final boolean isTruncateOp;
  private Scenario scenario;

  private enum Scenario {
    ALTER {
      @Override
      DumpType dumpType() {
        return DumpType.EVENT_ALTER_TABLE;
      }
    },
    RENAME {
      @Override
      DumpType dumpType() {
        return DumpType.EVENT_RENAME_TABLE;
      }
    },
    TRUNCATE {
      @Override
      DumpType dumpType() {
        return DumpType.EVENT_TRUNCATE_TABLE;
      }
    },
    DROP {
      @Override
      DumpType dumpType() {
        return DumpType.EVENT_RENAME_DROP_TABLE;
      }
    };


    abstract DumpType dumpType();
  }

  AlterTableHandler(NotificationEvent event) throws Exception {
    super(event);
    before = eventMessage.getTableObjBefore();
    after = eventMessage.getTableObjAfter();
    isTruncateOp = eventMessage.getIsTruncateOp();
    scenario = scenarioType(before, after);
  }

  @Override
  AlterTableMessage eventMessage(String stringRepresentation) {
    return deserializer.getAlterTableMessage(stringRepresentation);
  }

  private Scenario scenarioType(org.apache.hadoop.hive.metastore.api.Table before,
      org.apache.hadoop.hive.metastore.api.Table after) {
    if (before.getDbName().equals(after.getDbName())
        && before.getTableName().equals(after.getTableName())) {
      return isTruncateOp ? Scenario.TRUNCATE : Scenario.ALTER;
    } else {
      return Scenario.RENAME;
    }
  }

  // return true, if event needs to be dumped, else return false.
  private boolean handleRenameDuringTableLevelReplication(Context withinContext) {
    String oldName = before.getTableName();
    String newName = after.getTableName();

    if (ReplUtils.tableIncludedInReplScope(withinContext.replScope, oldName)) {
      // If old table satisfies the filter, but the new table does not, then the old table should be dropped.
      if (!ReplUtils.tableIncludedInReplScope(withinContext.replScope, newName)) {
        scenario = Scenario.DROP;
        LOG.info("Table " + oldName + " will be dropped as the table is renamed to " + newName);
        return true;
      }

      // If both old and new table satisfies the filter, then dump the rename event.
      return true;
    } else  {
      // if the old table does not satisfies the filter, but the new one satisfies, then the new table should be
      // added to the list of tables to be bootstrapped and don't dump the event.
      if (ReplUtils.tableIncludedInReplScope(withinContext.replScope, newName)) {
        LOG.info("Table " + newName + " is added for bootstrap " + " during rename from " + oldName);
        withinContext.tablesForBootstrap.add(newName);
        return false;
      }

      // if both old and new table does not satisfies the filter, then don't dump the event.
      return false;
    }
  }

  @Override
  public void handle(Context withinContext) throws Exception {
    LOG.info("Processing#{} ALTER_TABLE message : {}", fromEventId(), eventMessageAsJSON);

    Table qlMdTableBefore = new Table(before);
    if (Scenario.RENAME == scenario) {
      // If the table is renamed after being added to the list of tables to be bootstrapped, then remove it from the
      // list of tables to bne bootstrapped.
      withinContext.tablesForBootstrap.remove(before.getTableName());
    }

    if (!Utils
        .shouldReplicate(withinContext.replicationSpec, qlMdTableBefore,
            true, withinContext.tablesForBootstrap, withinContext.oldReplScope, withinContext.hiveConf)) {
      return;
    }

    if (withinContext.hiveConf.getBoolVar(HiveConf.ConfVars.REPL_BOOTSTRAP_ACID_TABLES)) {
      if (!AcidUtils.isTransactionalTable(before) && AcidUtils.isTransactionalTable(after)) {
        LOG.info("The table " + after.getTableName() + " is converted to ACID table." +
                " It will be replicated with bootstrap load as hive.repl.bootstrap.acid.tables is set to true.");
        return;
      }
    }

    // If the tables are filtered based on name, then needs to handle the rename scenarios.
    if (withinContext.replScope != null && !withinContext.replScope.includeAllTables()) {
      if (!handleRenameDuringTableLevelReplication(withinContext)) {
        LOG.info("Alter event for table " + before.getTableName() + " is skipped from dumping");
        return;
      }
    }

    if (Scenario.ALTER == scenario) {
      withinContext.replicationSpec.setIsMetadataOnly(true);
      Table qlMdTableAfter = new Table(after);
      Path metaDataPath = new Path(withinContext.eventRoot, EximUtil.METADATA_NAME);

      // If we are not dumping metadata about a table, we shouldn't be dumping basic statistics
      // as well, since that won't be accurate. So reset them to what they would look like for an
      // empty table.
      if (withinContext.hiveConf.getBoolVar(HiveConf.ConfVars.REPL_DUMP_METADATA_ONLY)) {
        qlMdTableAfter.setStatsStateLikeNewTable();
      }

      EximUtil.createExportDump(
          metaDataPath.getFileSystem(withinContext.hiveConf),
          metaDataPath,
          qlMdTableAfter,
          null,
          withinContext.replicationSpec,
          withinContext.hiveConf);
    }
 
    DumpMetaData dmd = withinContext.createDmd(this);
    dmd.setPayload(eventMessageAsJSON);
    dmd.write();
  }

  @Override
  public DumpType dumpType() {
    return scenario.dumpType();
  }
}
