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

import org.apache.hadoop.hive.metastore.api.Partition;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.hadoop.hive.metastore.messaging.InsertMessage;
import org.apache.hadoop.hive.metastore.messaging.OpenTxnMessage;
import org.apache.thrift.TException;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * JSON implementation of InsertMessage
 */
public class JSONOpenTxnMessage extends OpenTxnMessage {

  @JsonProperty
  Long txnid;
  @JsonProperty
  String db;
  @JsonProperty
  String user;

  String server;
  String servicePrincipal;
  Long timestamp;

  /**
   * Default constructor, needed for Jackson.
   */
  public JSONOpenTxnMessage() {
  }

  public JSONOpenTxnMessage(String server, String servicePrincipal, String db, String user, Long txnid, Long timestamp) {
    this.server = server;
    this.servicePrincipal = servicePrincipal;
    this.db = db;
    this.timestamp = timestamp;
    this.txnid = txnid;
    this.user = user;
    checkValid();
  }

  @Override
  public Long getTxnId() { return txnid; }

  @Override
  public String getServer() {
    return server;
  }

  @Override
  public String getServicePrincipal() {
    return servicePrincipal;
  }

  @Override
  public String getDB() {
    return db;
  }

  @Override
  public Long getTimestamp() {
    return timestamp;
  }

  @Override
  public String getUser() {
    return user;
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