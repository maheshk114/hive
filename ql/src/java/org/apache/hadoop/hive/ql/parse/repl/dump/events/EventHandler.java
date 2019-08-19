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
import org.apache.hadoop.hive.common.repl.ReplScope;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.ql.exec.repl.util.ReplUtils;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.metadata.Table;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.parse.ReplicationSpec;
import org.apache.hadoop.hive.ql.parse.SemanticAnalyzer;
import org.apache.hadoop.hive.ql.parse.TypeCheckCtx;
import org.apache.hadoop.hive.ql.parse.TypeCheckProcFactory;
import org.apache.hadoop.hive.ql.parse.repl.load.DumpMetaData;
import org.apache.hadoop.hive.ql.parse.repl.DumpType;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;

import java.util.Set;
import java.util.List;

public interface EventHandler {
  void handle(Context withinContext) throws Exception;

  long fromEventId();

  long toEventId();

  DumpType dumpType();

  class Context {
    Path eventRoot;
    final Path  cmRoot;
    final Hive db;
    final HiveConf hiveConf;
    final ReplicationSpec replicationSpec;
    final ReplScope replScope;
    final ReplScope oldReplScope;
    private Set<String> tablesForBootstrap;
    private Set<String> partitionsForBootstrap;

    public Context(Path eventRoot, Path cmRoot, Hive db, HiveConf hiveConf, ReplicationSpec replicationSpec,
                   ReplScope replScope, ReplScope oldReplScope, Set<String> tablesForBootstrap) {
      this.eventRoot = eventRoot;
      this.cmRoot = cmRoot;
      this.db = db;
      this.hiveConf = hiveConf;
      this.replicationSpec = replicationSpec;
      this.replScope = replScope;
      this.oldReplScope = oldReplScope;
      this.tablesForBootstrap = tablesForBootstrap;
    }

    public Context(Context other) {
      this.eventRoot = other.eventRoot;
      this.cmRoot = other.cmRoot;
      this.db = other.db;
      this.hiveConf = other.hiveConf;
      this.replicationSpec = other.replicationSpec;
      this.replScope = other.replScope;
      this.oldReplScope = other.oldReplScope;
      this.tablesForBootstrap = other.tablesForBootstrap;
    }

    void setEventRoot(Path eventRoot) {
      this.eventRoot = eventRoot;
    }

    DumpMetaData createDmd(EventHandler eventHandler) {
      return new DumpMetaData(
          eventRoot,
          eventHandler.dumpType(),
          eventHandler.fromEventId(),
          eventHandler.toEventId(),
          cmRoot, hiveConf
      );
    }

    Set<String> getTablesForBootstrap() {
      return tablesForBootstrap;
    }

    void addToListOfTablesForBootstrap(String tableName) {
      assert tableName != null;
      tablesForBootstrap.add(tableName.toLowerCase());
    }

    boolean removeFromListOfTablesForBootstrap(String tableName) {
      assert tableName != null;
      return tablesForBootstrap.remove(tableName.toLowerCase());
    }

    private boolean isPartSatisfiesFilter(ReplScope replicationScope, Table tbl, HiveConf conf,
                                          List<String> partValues) throws HiveException {
      ASTNode filterNode = (ASTNode)replicationScope.getPartFilter(tbl.getTableName());
      if (filterNode == null) {
        // Table has no filter, means all partitions are part of dump.
        return true;
      }
      ExprNodeDesc partitionFilter = TypeCheckProcFactory.genExprNode(filterNode,
              new TypeCheckCtx(SemanticAnalyzer.getRowResolverFromTable(tbl))).get(filterNode);
      return ReplUtils.isPartSatisfiesFilter(tbl, partValues, partitionFilter, conf);
    }

    public boolean isPartitionIncludedInDump(Table tbl, HiveConf conf, List<String> partValues) {
      try {
        if (isPartSatisfiesFilter(replScope, tbl, conf, partValues)) {
          // If partition satisfies the new filter but does not satisfies the old, then need to bootstrap the partition.
          // So the event dump should be skipped.
          if (isPartSatisfiesFilter(replScope, tbl, conf, partValues)) {
            return true;
          }
          partitionsForBootstrap.add(tbl.getTableName().toLowerCase());
        }
        return false;
      } catch (HiveException e) {
        throw new RuntimeException(e.getMessage());
      }
    }
  }
}
