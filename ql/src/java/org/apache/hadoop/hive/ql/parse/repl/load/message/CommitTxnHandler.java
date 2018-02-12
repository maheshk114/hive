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
package org.apache.hadoop.hive.ql.parse.repl.load.message;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.messaging.CommitTxnMessage;
import org.apache.hadoop.hive.ql.exec.ReplTxnWork;
import org.apache.hadoop.hive.ql.exec.Task;
import org.apache.hadoop.hive.ql.exec.TaskFactory;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.metadata.HiveUtils;
import org.apache.hadoop.hive.ql.metadata.InvalidTableException;
import org.apache.hadoop.hive.ql.metadata.Table;
import org.apache.hadoop.hive.ql.parse.ReplicationSpec;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * CommitTxnHandler
 * Target(Load) side handler for commit transaction event.
 */
public class CommitTxnHandler extends AbstractMessageHandler {
  @Override
  public List<Task<? extends Serializable>> handle(Context context)
          throws SemanticException {
    String txnMgr = context.hiveConf.getVar(HiveConf.ConfVars.HIVE_TXN_MANAGER);
    Boolean conc =  context.hiveConf.getBoolVar(HiveConf.ConfVars.HIVE_SUPPORT_CONCURRENCY);
    if (!txnMgr.equals("org.apache.hadoop.hive.ql.lockmgr.DbTxnManager") || conc != true) {
      context.log.error("Cannot load transaction events as acid is not enabled");
      throw new SemanticException("Cannot load transaction events as acid is not enabled");
    }

    CommitTxnMessage msg = deserializer.getCommitTxnMessage(context.dmd.getPayload());
    List<Task<? extends Serializable>> tasks = new ArrayList<>();

    String dbName = (context.dbName == null || context.isDbNameEmpty() ? msg.getDB() : context.dbName);
    String tableNamePrev = null;
    Table tbl;

    ReplTxnWork work = new ReplTxnWork(context.dbName, context.tableName, msg.getTxnId(),
            ReplTxnWork.OperationType.REPL_COMMIT_TXN);

    int numEntry = (msg.getTables() == null ? 0 : msg.getTables().size());
    for (int idx = 0; idx < numEntry; idx++) {
      String actualTblName = msg.getTables().get(idx);
      try {
        tbl = context.db.getTable(dbName, actualTblName);
        Map<String, String> params = tbl.getParameters();
        if (params != null && (params.containsKey(ReplicationSpec.KEY.CURR_STATE_ID.toString()))) {
          String replLastId = params.get(ReplicationSpec.KEY.CURR_STATE_ID.toString());
          if (Long.parseLong(replLastId) >= context.dmd.getEventTo()) {
            // if the event is already replayed, then no need to replay it again.
            continue;
          }
        }
      } catch (InvalidTableException e) {
        //Table not present. May be deleted.  May be deleted or create table in the same dump task. Replay the event.
        context.log.info("Table " + actualTblName + " is not present. May be deleted or create table " +
                " in the same dump task.");
      } catch (HiveException e) {
        throw new SemanticException("Get table " + actualTblName + " failed with exception : " + e.getMessage());
      }

      //one import task per table
      if (tableNamePrev == null || !actualTblName.equals(tableNamePrev)) {
        String tblName = context.isTableNameEmpty() ? actualTblName : context.tableName;
        String location = context.location + Path.SEPARATOR +
                HiveUtils.getDumpPath(msg.getDatabases().get(idx), actualTblName);
        Context currentContext = new Context(dbName, tblName, location, context.precursor,
                context.dmd, context.hiveConf, context.db, context.nestedContext, context.log);
        currentContext.setWriteId(msg.getWriteIds().get(idx));
        // Piggybacking in Import logic for now
        TableHandler tableHandler = new TableHandler();
        tasks.addAll((tableHandler.handle(currentContext)));
        readEntitySet.addAll(tableHandler.readEntities());
        writeEntitySet.addAll(tableHandler.writeEntities());
        getUpdatedMetadata().copyUpdatedMetadata(tableHandler.getUpdatedMetadata());
        tableNamePrev = actualTblName;
      }

      String db = (context.dbName == null || context.dbName.isEmpty() ? msg.getDatabases().get(idx) : context.dbName);
      String table = (context.tableName == null || context.tableName.isEmpty() ? msg.getDatabases().get(idx) : context.tableName);
      work.addCommitTxnInfo(db, table, msg.getPartitions().get(idx), msg.getWriteIds().get(idx));
    }

    Task<ReplTxnWork> commitTxnTask = TaskFactory.get(work, context.hiveConf);
    updatedMetadata.set(context.dmd.getEventTo().toString(), context.dbName, context.tableName, null);
    context.log.debug("Added Commit txn task : {}", commitTxnTask.getId());
    tasks.add(commitTxnTask);
    return tasks;
  }
}
