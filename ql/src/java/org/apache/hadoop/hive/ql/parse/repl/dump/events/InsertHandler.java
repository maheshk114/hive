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

import com.google.common.collect.Lists;
import org.apache.commons.collections.iterators.SingletonListIterator;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.conf.HiveConf.ConfVars;
import org.apache.hadoop.hive.metastore.api.NotificationEvent;
import org.apache.hadoop.hive.metastore.messaging.InsertMessage;
import org.apache.hadoop.hive.ql.io.AcidUtils;
import org.apache.hadoop.hive.ql.metadata.HiveUtils;
import org.apache.hadoop.hive.ql.metadata.Partition;
import org.apache.hadoop.hive.ql.parse.EximUtil;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.apache.hadoop.hive.ql.parse.repl.DumpType;
import org.apache.hadoop.hive.ql.parse.repl.dump.Utils;
import org.apache.hadoop.hive.ql.parse.repl.load.DumpMetaData;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


class InsertHandler extends AbstractEventHandler {

  InsertHandler(NotificationEvent event) {
    super(event);
  }

  public static void createDumpFile(Context withinContext, org.apache.hadoop.hive.ql.metadata.Table qlMdTable,
                             List<Partition> qlPtns, boolean isReplace, List<List<String>> fileListArray)
          throws IOException, SemanticException {
    Path metaDataPath = new Path(withinContext.eventRoot, EximUtil.METADATA_NAME);

    // Mark the replace type based on INSERT-INTO or INSERT_OVERWRITE operation
    withinContext.replicationSpec.setIsReplace(isReplace);
    EximUtil.createExportDump(metaDataPath.getFileSystem(withinContext.hiveConf), metaDataPath,
            qlMdTable, qlPtns,
            withinContext.replicationSpec,
            withinContext.hiveConf);

    if (fileListArray != null && fileListArray.size() > 0) {
      Path dataPath;
      if ((null == qlPtns) || qlPtns.isEmpty()) {
        dataPath = new Path(withinContext.eventRoot, EximUtil.DATA_PATH_NAME);
        Iterable<String> files = fileListArray.get(0);
        // encoded filename/checksum of files, write into _files
        try (BufferedWriter fileListWriter = writer(withinContext, dataPath)) {
          for (String file : files) {
            fileListWriter.write(file + "\n");
          }
        }
      } else {
        for (int idx = 0; idx < qlPtns.size(); idx++) {
          dataPath = new Path(withinContext.eventRoot, qlPtns.get(idx).getName());
          Iterable<String> files = fileListArray.get(idx);
          // encoded filename/checksum of files, write into _files
          try (BufferedWriter fileListWriter = writer(withinContext, dataPath)) {
            for (String file : files) {
              fileListWriter.write(file + "\n");
            }
          }
        }
      }
    }
  }

  @Override
  public void handle(Context withinContext) throws Exception {
    if (withinContext.hiveConf.getBoolVar(ConfVars.REPL_DUMP_METADATA_ONLY)) {
      return;
    }
    InsertMessage insertMsg = deserializer.getInsertMessage(event.getMessage());
    org.apache.hadoop.hive.ql.metadata.Table qlMdTable = tableObject(insertMsg);

    if (!Utils.shouldReplicate(withinContext.replicationSpec, qlMdTable, withinContext.hiveConf)) {
      return;
    }

    // insert event should not be generated for ACID tables. ACID tables should generate ACID_WRITE events.
    boolean isAcidTable = AcidUtils.isTransactionalTable(qlMdTable);
    assert (isAcidTable != true);

    List<Partition> qlPtns = null;
    if (qlMdTable.isPartitioned() && (null != insertMsg.getPtnObj())) {
      qlPtns = Collections.singletonList(partitionObject(qlMdTable, insertMsg));
    }

    createDumpFile(withinContext, qlMdTable, qlPtns, insertMsg.isReplace(),
            Collections.singletonList(Lists.newArrayList(insertMsg.getFiles())));

    LOG.info("Processing#{} INSERT message : {}", fromEventId(), event.getMessage());
    DumpMetaData dmd = withinContext.createDmd(this);
    dmd.setPayload(event.getMessage());
    dmd.write();
  }

  private org.apache.hadoop.hive.ql.metadata.Table tableObject(InsertMessage insertMsg) throws Exception {
    return new org.apache.hadoop.hive.ql.metadata.Table(insertMsg.getTableObj());
  }

  private org.apache.hadoop.hive.ql.metadata.Partition partitionObject(
          org.apache.hadoop.hive.ql.metadata.Table qlMdTable, InsertMessage insertMsg) throws Exception {
    return new org.apache.hadoop.hive.ql.metadata.Partition(qlMdTable, insertMsg.getPtnObj());
  }

  private static BufferedWriter writer(Context withinContext, Path dataPath) throws IOException {
    Path filesPath = new Path(dataPath, EximUtil.FILES_NAME);
    FileSystem fs = dataPath.getFileSystem(withinContext.hiveConf);
    return new BufferedWriter(new OutputStreamWriter(fs.create(filesPath)));
  }

  @Override
  public DumpType dumpType() {
    return DumpType.EVENT_INSERT;
  }
}
