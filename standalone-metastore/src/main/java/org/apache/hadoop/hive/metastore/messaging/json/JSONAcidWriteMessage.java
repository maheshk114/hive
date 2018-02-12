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
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.hadoop.hive.metastore.messaging.json;

import com.google.common.collect.Lists;
import org.apache.hadoop.hive.metastore.api.Partition;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.hadoop.hive.metastore.messaging.AcidWriteMessage;
import org.apache.thrift.TException;
import org.codehaus.jackson.annotate.JsonProperty;
import java.util.Iterator;
import java.util.List;

/**
 * JSON implementation of CommitTxnMessage
 */
public class JSONAcidWriteMessage extends AcidWriteMessage {

  @JsonProperty
  private Long txnid;

  @JsonProperty
  private Long timestamp;

  @JsonProperty
  private String server;

  @JsonProperty
  private String servicePrincipal;

  @JsonProperty
  private String database, table, partitions;

  @JsonProperty
  private  Long writeId;

  @JsonProperty
  private List<String> files;

  @JsonProperty
  private String tableObjJason;

  @JsonProperty
  private String partitionObjJson;

  /**
   * Default constructor, needed for Jackson.
   */
  public JSONAcidWriteMessage() {
  }

  public JSONAcidWriteMessage(String server, String servicePrincipal, Long txnid, Long timestamp,
                              String database, String table, Long writeId,
                              String partitions, Table tableObj,
                              Partition partitionObj, Iterator<String> files) {
    this.timestamp = timestamp;
    this.txnid = txnid;
    this.server = server;
    this.servicePrincipal = servicePrincipal;
    this.database = database;
    this.table = table;
    this.writeId = writeId;
    this.partitions = partitions;
    try {
      this.tableObjJason = JSONMessageFactory.createTableObjJson(tableObj);
      if (partitionObj != null) {
        this.partitionObjJson = JSONMessageFactory.createPartitionObjJson(partitionObj);
      } else {
        this.partitionObjJson = null;
      }
    } catch (TException e) {
      throw new IllegalArgumentException("Could not serialize JSONAcidWriteMessage : ", e);
    }
    this.files = Lists.newArrayList(files);
  }

  @Override
  public Long getTxnId() {
    return txnid;
  }

  @Override
  public Long getTimestamp() {
    return timestamp;
  }

  @Override
  public String getDB() {
    return null;
  }

  @Override
  public String getServicePrincipal() {
    return servicePrincipal;
  }

  @Override
  public String getServer() {
    return server;
  }

  @Override
  public String getDatabase() {
    return database;
  }

  @Override
  public String getTable() {
    return table;
  }

  @Override
  public Long getWriteId() {
    return writeId;
  }

  @Override
  public String getPartitions() {
    return partitions;
  }

  @Override
  public List<String> getFiles() {
    return files;
  }

  @Override
  public Table getTableObj() throws Exception {
    return (Table) JSONMessageFactory.getTObj(tableObjJason,Table.class);
  }

  @Override
  public Partition getPartitionObj() throws Exception {
    return ((null == tableObjJason) ? null : (Partition) JSONMessageFactory.getTObj(tableObjJason, Partition.class));
  }

  @Override
  public String getTableObjStr() throws TException {
    return tableObjJason;
  }

  @Override
  public String getPartitionObjStr() throws TException {
    return partitionObjJson;
  }

  @Override
  public String toString() {
    try {
      return JSONMessageDeserializer.mapper.writeValueAsString(this);
    } catch (Exception exception) {
      throw new IllegalArgumentException("Could not serialize: ", exception);
    }
  }
}
