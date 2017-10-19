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

import com.google.common.collect.Lists;
import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;
import org.apache.hadoop.hive.metastore.IHMSHandler;
import org.apache.hadoop.hive.metastore.api.ClientCapabilities;
import org.apache.hadoop.hive.metastore.api.ClientCapability;
import org.apache.hadoop.hive.metastore.api.GetTableRequest;
import org.apache.hadoop.hive.metastore.api.InsertEventRequestData;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.api.NoSuchObjectException;
import org.apache.hadoop.hive.metastore.api.Partition;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.hadoop.hive.metastore.utils.MetaStoreUtils;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

@InterfaceAudience.Public
@InterfaceStability.Stable
public class OpenTxnEvent extends ListenerEvent {

  private final Long txnId;
  private final String db;
  private final String user;

  /**
   *
   * @param transactionId Unique identification for the transaction just opened.
   * @param status status of insert, true = success, false = failure
   * @param handler handler that is firing the event
   */
  public OpenTxnEvent(Long transactionId, String db, String user, boolean status, IHMSHandler handler) throws MetaException,
      NoSuchObjectException {
    super(status, handler);
    txnId = transactionId;
    this.db = db;
    this.user = user;
  }

  /**
   * @return Long txnId
   */
  public Long getTxnId() {
    return txnId;
  }

  public String getDb() { return db; }

  public String getUser() { return user; }

}
