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

package org.apache.hadoop.hive.metastore.events;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;
import org.apache.hadoop.hive.metastore.api.Partition;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.hadoop.hive.metastore.tools.SQLGenerator;

import java.sql.Connection;
import java.util.List;

/**
 * AbortTxnEvent
 * Event generated for roll backing a transaction
 */
@InterfaceAudience.Public
@InterfaceStability.Stable
public class AcidWriteEvent extends ListenerEvent {

  private final Long txnId, writeId;
  private String database, table, partition;
  private Table tableObj;
  private Partition partitionObj;
  private List<String> files, checksums, subDirs;
  private Connection dbConn;
  private SQLGenerator sqlGenerator;

  public AcidWriteEvent(Long transactionId,
                        String databases,
                        String tables,
                        Long writeIds,
                        String partitions,
                        Table tableObj,
                        Partition partitionObj,
                        List<String> files,
                        List<String> checksums,
                        List<String> subDirs,
                        Connection dbConn,
                        SQLGenerator sqlGenerator) {
    super(true, null);
    txnId = transactionId;
    this.database = databases;
    this.table = tables;
    this.writeId = writeIds;
    this.partition = partitions;
    this.tableObj = tableObj;
    this.partitionObj = partitionObj;
    this.files = files;
    this.checksums = checksums;
    this.dbConn = dbConn;
    this.sqlGenerator = sqlGenerator;
    this.subDirs = subDirs;
  }

  /**
   * @return Long txnId
   */
  public Long getTxnId() {
    return txnId;
  }


  public List<String> getFiles() {
    return files;
  }

  public List<String> getChecksums() {
    return checksums;
  }

  public String getDatabase() {
    return database;
  }

  public String getTable() {
    return table;
  }

  public String getPartition() {
    return partition;
  }

  public Long getWriteId() {
    return writeId;
  }

  public Table getTableObj() {
    return tableObj;
  }

  public Partition getPartitionObj() {
    return partitionObj;
  }

  public Connection getDbConn() {
    return dbConn;
  }

  public SQLGenerator getSqlGenerator() {
    return sqlGenerator;
  }

  public List<String> getSubDirs() {
    return subDirs;
  }
}
