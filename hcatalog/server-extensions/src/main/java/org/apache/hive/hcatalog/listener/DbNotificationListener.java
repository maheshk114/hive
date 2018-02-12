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
package org.apache.hive.hcatalog.listener;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;
import org.apache.hadoop.hive.metastore.HiveMetaStore.HMSHandler;
import org.apache.hadoop.hive.metastore.MetaStoreEventListenerConstants;
import org.apache.hadoop.hive.metastore.RawStore;
import org.apache.hadoop.hive.metastore.RawStoreProxy;
import org.apache.hadoop.hive.metastore.ReplChangeManager;
import org.apache.hadoop.hive.metastore.TransactionalMetaStoreEventListener;
import org.apache.hadoop.hive.metastore.Warehouse;
import org.apache.hadoop.hive.metastore.api.Database;
import org.apache.hadoop.hive.metastore.api.Function;
import org.apache.hadoop.hive.metastore.api.Index;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.api.NotificationEvent;
import org.apache.hadoop.hive.metastore.api.Partition;
import org.apache.hadoop.hive.metastore.api.SQLForeignKey;
import org.apache.hadoop.hive.metastore.api.SQLNotNullConstraint;
import org.apache.hadoop.hive.metastore.api.SQLPrimaryKey;
import org.apache.hadoop.hive.metastore.api.SQLUniqueConstraint;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.hadoop.hive.metastore.conf.MetastoreConf;
import org.apache.hadoop.hive.metastore.conf.MetastoreConf.ConfVars;
import org.apache.hadoop.hive.metastore.events.*;
import org.apache.hadoop.hive.metastore.messaging.AcidWriteMessage;
import org.apache.hadoop.hive.metastore.messaging.EventMessage.EventType;
import org.apache.hadoop.hive.metastore.messaging.MessageFactory;
import org.apache.hadoop.hive.metastore.messaging.PartitionFiles;
import org.apache.hadoop.hive.metastore.tools.SQLGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.collect.Lists;

/**
 * An implementation of {@link org.apache.hadoop.hive.metastore.MetaStoreEventListener} that
 * stores events in the database.
 *
 * Design overview:  This listener takes any event, builds a NotificationEventResponse,
 * and puts it on a queue.  There is a dedicated thread that reads entries from the queue and
 * places them in the database.  The reason for doing it in a separate thread is that we want to
 * avoid slowing down other metadata operations with the work of putting the notification into
 * the database.  Also, occasionally the thread needs to clean the database of old records.  We
 * definitely don't want to do that as part of another metadata operation.
 */
public class DbNotificationListener extends TransactionalMetaStoreEventListener {

  private static final Logger LOG = LoggerFactory.getLogger(DbNotificationListener.class.getName());
  private static CleanerThread cleaner = null;

  private Configuration conf;
  private MessageFactory msgFactory;

  private synchronized void init(Configuration conf) throws MetaException {
    if (cleaner == null) {
      cleaner =
          new CleanerThread(conf, RawStoreProxy.getProxy(conf, conf,
              MetastoreConf.getVar(conf, ConfVars.RAW_STORE_IMPL), 999999));
      cleaner.start();
    }
  }

  public DbNotificationListener(Configuration config) throws MetaException {
    super(config);
    conf = config;
    init(conf);
    msgFactory = MessageFactory.getInstance();
  }

  /**
   * @param tableEvent table event.
   * @throws org.apache.hadoop.hive.metastore.api.MetaException
   */
  @Override
  public void onConfigChange(ConfigChangeEvent tableEvent) throws MetaException {
    String key = tableEvent.getKey();
    if (key.equals(ConfVars.EVENT_DB_LISTENER_TTL.toString()) ||
        key.equals(ConfVars.EVENT_DB_LISTENER_TTL.getHiveName())) {
      // This weirdness of setting it in our conf and then reading back does two things.
      // One, it handles the conversion of the TimeUnit.  Two, it keeps the value around for
      // later in case we need it again.
      long time = MetastoreConf.convertTimeStr(tableEvent.getNewValue(), TimeUnit.SECONDS,
          TimeUnit.SECONDS);
      MetastoreConf.setTimeVar(getConf(), MetastoreConf.ConfVars.EVENT_DB_LISTENER_TTL, time,
          TimeUnit.SECONDS);
      cleaner.setTimeToLive(MetastoreConf.getTimeVar(getConf(),
          MetastoreConf.ConfVars.EVENT_DB_LISTENER_TTL, TimeUnit.SECONDS));
    }
  }

  /**
   * @param tableEvent table event.
   * @throws MetaException
   */
  @Override
  public void onCreateTable(CreateTableEvent tableEvent) throws MetaException {
    Table t = tableEvent.getTable();
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.CREATE_TABLE.toString(), msgFactory
            .buildCreateTableMessage(t, new FileIterator(t.getSd().getLocation())).toString());
    event.setDbName(t.getDbName());
    event.setTableName(t.getTableName());
    process(event, tableEvent);
  }

  /**
   * @param tableEvent table event.
   * @throws MetaException
   */
  @Override
  public void onDropTable(DropTableEvent tableEvent) throws MetaException {
    Table t = tableEvent.getTable();
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.DROP_TABLE.toString(), msgFactory
            .buildDropTableMessage(t).toString());
    event.setDbName(t.getDbName());
    event.setTableName(t.getTableName());
    process(event, tableEvent);
  }

  /**
   * @param tableEvent alter table event
   * @throws MetaException
   */
  @Override
  public void onAlterTable(AlterTableEvent tableEvent) throws MetaException {
    Table before = tableEvent.getOldTable();
    Table after = tableEvent.getNewTable();
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.ALTER_TABLE.toString(), msgFactory
            .buildAlterTableMessage(before, after, tableEvent.getIsTruncateOp()).toString());
    event.setDbName(after.getDbName());
    event.setTableName(after.getTableName());
    process(event, tableEvent);
  }

  class FileIterator implements Iterator<String> {
    /***
     * Filter for valid files only (no dir, no hidden)
     */
    PathFilter VALID_FILES_FILTER = new PathFilter() {
      @Override
      public boolean accept(Path p) {
        try {
          if (!fs.isFile(p)) {
            return false;
          }
          String name = p.getName();
          return !name.startsWith("_") && !name.startsWith(".");
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    };
    private FileSystem fs;
    private FileStatus[] files;
    private int i = 0;
    FileIterator(String locString) {
      try {
        if (locString != null) {
          Path loc = new Path(locString);
          fs = loc.getFileSystem(conf);
          files = fs.listStatus(loc, VALID_FILES_FILTER);
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public boolean hasNext() {
      if (files == null) {
        return false;
      }
      return i<files.length;
    }

    @Override
    public String next() {
      try {
        FileStatus file = files[i];
        i++;
        return ReplChangeManager.encodeFileUri(file.getPath().toString(),
            ReplChangeManager.checksumFor(file.getPath(), fs), null);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
  class PartitionFilesIterator implements Iterator<PartitionFiles> {

    private Iterator<Partition> partitionIter;
    private Table t;

    PartitionFilesIterator(Iterator<Partition> partitionIter, Table t) {
      this.partitionIter = partitionIter;
      this.t = t;
    }
    @Override
    public boolean hasNext() {
      return partitionIter.hasNext();
    }

    @Override
    public PartitionFiles next() {
      try {
        Partition p = partitionIter.next();
        List<String> files = Lists.newArrayList(new FileIterator(p.getSd().getLocation()));
        PartitionFiles partitionFiles =
            new PartitionFiles(Warehouse.makePartName(t.getPartitionKeys(), p.getValues()),
            files.iterator());
        return partitionFiles;
      } catch (MetaException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
  /**
   * @param partitionEvent partition event
   * @throws MetaException
   */
  @Override
  public void onAddPartition(AddPartitionEvent partitionEvent) throws MetaException {
    Table t = partitionEvent.getTable();
    String msg = msgFactory
        .buildAddPartitionMessage(t, partitionEvent.getPartitionIterator(),
            new PartitionFilesIterator(partitionEvent.getPartitionIterator(), t)).toString();
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.ADD_PARTITION.toString(), msg);
    event.setDbName(t.getDbName());
    event.setTableName(t.getTableName());
    process(event, partitionEvent);
  }

  /**
   * @param partitionEvent partition event
   * @throws MetaException
   */
  @Override
  public void onDropPartition(DropPartitionEvent partitionEvent) throws MetaException {
    Table t = partitionEvent.getTable();
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.DROP_PARTITION.toString(), msgFactory
            .buildDropPartitionMessage(t, partitionEvent.getPartitionIterator()).toString());
    event.setDbName(t.getDbName());
    event.setTableName(t.getTableName());
    process(event, partitionEvent);
  }

  /**
   * @param partitionEvent partition event
   * @throws MetaException
   */
  @Override
  public void onAlterPartition(AlterPartitionEvent partitionEvent) throws MetaException {
    Partition before = partitionEvent.getOldPartition();
    Partition after = partitionEvent.getNewPartition();
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.ALTER_PARTITION.toString(), msgFactory
            .buildAlterPartitionMessage(partitionEvent.getTable(), before, after, partitionEvent.getIsTruncateOp()).toString());
    event.setDbName(before.getDbName());
    event.setTableName(before.getTableName());
    process(event, partitionEvent);
  }

  /**
   * @param dbEvent database event
   * @throws MetaException
   */
  @Override
  public void onCreateDatabase(CreateDatabaseEvent dbEvent) throws MetaException {
    Database db = dbEvent.getDatabase();
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.CREATE_DATABASE.toString(), msgFactory
            .buildCreateDatabaseMessage(db).toString());
    event.setDbName(db.getName());
    process(event, dbEvent);
  }

  /**
   * @param dbEvent database event
   * @throws MetaException
   */
  @Override
  public void onDropDatabase(DropDatabaseEvent dbEvent) throws MetaException {
    Database db = dbEvent.getDatabase();
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.DROP_DATABASE.toString(), msgFactory
            .buildDropDatabaseMessage(db).toString());
    event.setDbName(db.getName());
    process(event, dbEvent);
  }

  /**
   * @param dbEvent alter database event
   * @throws MetaException
   */
  @Override
  public void onAlterDatabase(AlterDatabaseEvent dbEvent) throws MetaException {
    Database oldDb = dbEvent.getOldDatabase();
    Database newDb = dbEvent.getNewDatabase();
    NotificationEvent event =
            new NotificationEvent(0, now(), EventType.ALTER_DATABASE.toString(), msgFactory
                    .buildAlterDatabaseMessage(oldDb, newDb).toString());
    event.setDbName(oldDb.getName());
    process(event, dbEvent);
  }

  /**
   * @param fnEvent function event
   * @throws MetaException
   */
  @Override
  public void onCreateFunction(CreateFunctionEvent fnEvent) throws MetaException {
    Function fn = fnEvent.getFunction();
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.CREATE_FUNCTION.toString(), msgFactory
            .buildCreateFunctionMessage(fn).toString());
    event.setDbName(fn.getDbName());
    process(event, fnEvent);
  }

  /**
   * @param fnEvent function event
   * @throws MetaException
   */
  @Override
  public void onDropFunction(DropFunctionEvent fnEvent) throws MetaException {
    Function fn = fnEvent.getFunction();
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.DROP_FUNCTION.toString(), msgFactory
            .buildDropFunctionMessage(fn).toString());
    event.setDbName(fn.getDbName());
    process(event, fnEvent);
  }

  /**
   * @param indexEvent index event
   * @throws MetaException
   */
  @Override
  public void onAddIndex(AddIndexEvent indexEvent) throws MetaException {
    Index index = indexEvent.getIndex();
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.CREATE_INDEX.toString(), msgFactory
            .buildCreateIndexMessage(index).toString());
    event.setDbName(index.getDbName());
    process(event, indexEvent);
  }

  /**
   * @param indexEvent index event
   * @throws MetaException
   */
  @Override
  public void onDropIndex(DropIndexEvent indexEvent) throws MetaException {
    Index index = indexEvent.getIndex();
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.DROP_INDEX.toString(), msgFactory
            .buildDropIndexMessage(index).toString());
    event.setDbName(index.getDbName());
    process(event, indexEvent);
  }

  /**
   * @param indexEvent index event
   * @throws MetaException
   */
  @Override
  public void onAlterIndex(AlterIndexEvent indexEvent) throws MetaException {
    Index before = indexEvent.getOldIndex();
    Index after = indexEvent.getNewIndex();
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.ALTER_INDEX.toString(), msgFactory
            .buildAlterIndexMessage(before, after).toString());
    event.setDbName(before.getDbName());
    process(event, indexEvent);
  }

  class FileChksumIterator implements Iterator<String> {
    private List<String> files;
    private List<String> chksums;
    private List<String> subDirs;
    int i = 0;
    FileChksumIterator(List<String> files, List<String> chksums) {
      this.files = files;
      this.chksums = chksums;
      this.subDirs = subDirs;
    }
    FileChksumIterator(List<String> files, List<String> chksums, List<String> subDirs) {
      this.files = files;
      this.chksums = chksums;
      this.subDirs = subDirs;
    }
    @Override
    public boolean hasNext() {
      return i< files.size();
    }

    @Override
    public String next() {
      String result = encodeFileUri(files.get(i), chksums != null? chksums.get(i) : null,
              subDirs != null ? subDirs.get(i) : null);
      i++;
      return result;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
  @Override
  public void onInsert(InsertEvent insertEvent) throws MetaException {
    Table tableObj = insertEvent.getTableObj();
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.INSERT.toString(), msgFactory.buildInsertMessage(tableObj,
                insertEvent.getPartitionObj(), insertEvent.isReplace(),
            new FileChksumIterator(insertEvent.getFiles(), insertEvent.getFileChecksums()))
                .toString());
    event.setDbName(tableObj.getDbName());
    event.setTableName(tableObj.getTableName());
    process(event, insertEvent);
  }

  @Override
  public void onOpenTxn(OpenTxnEvent openTxnEvent) throws MetaException {
    NotificationEvent event =
            new NotificationEvent(0, now(), EventType.OPEN_TXN.toString(), msgFactory.buildOpenTxnMessage(
                    openTxnEvent.getTxnIds())
                    .toString());
    process(event, openTxnEvent);
  }

  @Override
  public void onCommitTxn(CommitTxnEvent commitTxnEvent) throws MetaException {
    NotificationEvent event =
            new NotificationEvent(0, now(), EventType.COMMIT_TXN.toString(), msgFactory.buildCommitTxnMessage(
                    commitTxnEvent.getTxnId())
                    .toString());
    process(event, commitTxnEvent);
  }

  @Override
  public void onAbortTxn(AbortTxnEvent abortTxnEvent) throws MetaException {
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.ABORT_TXN.toString(), msgFactory.buildAbortTxnMessage(
            abortTxnEvent.getTxnId())
            .toString());

    process(event, abortTxnEvent);
  }

  static String quoteString(String input) {
    return "'" + input + "'";
  }

  private long getNextSequenceVal(ResultSet rs, Statement stmt, SQLGenerator sqlGenerator)
          throws SQLException, MetaException {
    String s = sqlGenerator.addForUpdateClause("select \"NEXT_VAL\" from " +
            "\"SEQUENCE_TABLE\" where \"SEQUENCE_NAME\" = " +
            " 'org.apache.hadoop.hive.metastore.model.MWriteNotificationLog'");
    LOG.debug("Going to execute query <" + s + ">");
    rs = stmt.executeQuery(s);
    if (!rs.next()) {
      throw new MetaException("Transaction database not properly " +
              "configured, can't find next event id.");
    }

    long nextNLId = rs.getLong(1);
    long updatedNLId = nextNLId + 1;
    s = "update \"SEQUENCE_TABLE\" set \"NEXT_VAL\" = " + updatedNLId + " where \"SEQUENCE_NAME\" = " +
            " 'org.apache.hadoop.hive.metastore.model.MWriteNotificationLog'";
    LOG.debug("Going to execute update <" + s + ">");
    stmt.executeUpdate(s);
    return nextNLId;
  }

  @Override
  public void onAcidWrite(AcidWriteEvent acidWriteEvent) throws MetaException {
    AcidWriteMessage msg = msgFactory.buildAcidWriteMessage(acidWriteEvent.getTxnId(), acidWriteEvent.getDatabase(),
            acidWriteEvent.getTable(), acidWriteEvent.getWriteId(), acidWriteEvent.getPartition(), acidWriteEvent.getTableObj(),
            acidWriteEvent.getPartitionObj(),
            new FileChksumIterator(acidWriteEvent.getFiles(), acidWriteEvent.getChecksums(), acidWriteEvent.getSubDirs()));
    NotificationEvent event = new NotificationEvent(0, now(), EventType.ACID_WRITE_ID_EVENT.toString(),
            msg.toString());
    try {
      Statement stmt = acidWriteEvent.getDbConn().createStatement();
      StringBuilder sb = new StringBuilder();
      for (String file : msg.getFiles()) {
        sb.append(file).append(",");
      }
      sb.deleteCharAt(sb.length() -1);

      String dbName = acidWriteEvent.getDatabase();
      String tblName = acidWriteEvent.getTable();
      String partition = acidWriteEvent.getPartition();
      String s = acidWriteEvent.getSqlGenerator().addForUpdateClause(
              "select WNL_FILES, WNL_ID from WRITE_NOTIFICATION_LOG where WNL_DATABASE = " + quoteString(dbName) +
                      "and WNL_TABLE = " + quoteString(tblName) +  " and WNL_PARTITION = " + quoteString(partition) +
                      " and WNL_TXNID = " + Long.toString(acidWriteEvent.getTxnId()));
      LOG.debug("Going to execute query <" + s + ">");
      ResultSet rs = stmt.executeQuery(s);
      if (!rs.next()) {
        // if rs is empty then no lock is taken and thus it can not cause deadlock.
        long nextNLId = getNextSequenceVal(rs, stmt, acidWriteEvent.getSqlGenerator());
        s = "insert into WRITE_NOTIFICATION_LOG (WNL_ID, WNL_TXNID, WNL_WRITEID, WNL_DATABASE, WNL_TABLE," +
                " WNL_PARTITION, WNL_TABLE_OBJ, WNL_PARTITION_OBJ, WNL_FILES, WNL_EVENT_TIME) values (" + nextNLId
                + "," + acidWriteEvent.getTxnId() +  "," + acidWriteEvent.getWriteId()+  "," +
                quoteString(acidWriteEvent.getDatabase())+  "," +  quoteString(acidWriteEvent.getTable())+  "," +
                quoteString(acidWriteEvent.getPartition())+  "," +  quoteString(msg.getTableObjStr())+  "," +
                quoteString(msg.getPartitionObjStr()) +  "," +  quoteString(sb.toString())+
                "," +  Integer.toString(now()) + ")";
        LOG.info("Going to execute insert <" + s + ">");
        stmt.execute(s.replaceAll("\\\\", "\\\\\\\\"));
      } else {
        String existingFiles = rs.getString(1);
        if (existingFiles.contains(sb.toString().replaceAll("\\\\", "\\\\\\\\"))) {
          //if list of files are already present then no need to update it again.
          LOG.info("file list " + sb.toString() + " already present");
          return;
        }
        long nlId = rs.getLong(2);
        sb.append(",").append(existingFiles);
        s = "update WRITE_NOTIFICATION_LOG set WNL_TABLE_OBJ = " +  quoteString(msg.getTableObjStr()) + "," +
                " WNL_PARTITION_OBJ = " + quoteString(msg.getPartitionObjStr()) + "," +
                " WNL_FILES = " + quoteString(sb.toString()) + "," +
                " WNL_EVENT_TIME = " + Integer.toString(now()) +
                " where WNL_ID = " + nlId;
        LOG.info("Going to execute update <" + s + ">");
        stmt.executeUpdate(s.replaceAll("\\\\", "\\\\\\\\"));
      }
    }
    catch (Exception e) {
      throw new MetaException("Unable to process acid write event " + e.getMessage());
    } finally {
      // Set the DB_NOTIFICATION_EVENT_ID for future reference by other listeners.
      if (event.isSetEventId()) {
        acidWriteEvent.putParameter(
                MetaStoreEventListenerConstants.DB_NOTIFICATION_EVENT_ID_KEY_NAME,
                Long.toString(event.getEventId()));
      }
    }
  }

  /**
   * @param partSetDoneEvent
   * @throws MetaException
   */
  @Override
  public void onLoadPartitionDone(LoadPartitionDoneEvent partSetDoneEvent) throws MetaException {
    // TODO, we don't support this, but we should, since users may create an empty partition and
    // then load data into it.
  }

  /***
   * @param addPrimaryKeyEvent add primary key event
   * @throws MetaException
   */
  @Override
  public void onAddPrimaryKey(AddPrimaryKeyEvent addPrimaryKeyEvent) throws MetaException {
    List<SQLPrimaryKey> cols = addPrimaryKeyEvent.getPrimaryKeyCols();
    if (cols.size() > 0) {
      NotificationEvent event =
          new NotificationEvent(0, now(), EventType.ADD_PRIMARYKEY.toString(), msgFactory
              .buildAddPrimaryKeyMessage(addPrimaryKeyEvent.getPrimaryKeyCols()).toString());
      event.setDbName(cols.get(0).getTable_db());
      event.setTableName(cols.get(0).getTable_name());
      process(event, addPrimaryKeyEvent);
    }
  }

  /***
   * @param addForeignKeyEvent add foreign key event
   * @throws MetaException
   */
  @Override
  public void onAddForeignKey(AddForeignKeyEvent addForeignKeyEvent) throws MetaException {
    List<SQLForeignKey> cols = addForeignKeyEvent.getForeignKeyCols();
    if (cols.size() > 0) {
      NotificationEvent event =
          new NotificationEvent(0, now(), EventType.ADD_FOREIGNKEY.toString(), msgFactory
              .buildAddForeignKeyMessage(addForeignKeyEvent.getForeignKeyCols()).toString());
      event.setDbName(cols.get(0).getPktable_db());
      event.setTableName(cols.get(0).getPktable_name());
      process(event, addForeignKeyEvent);
    }
  }

  /***
   * @param addUniqueConstraintEvent add unique constraint event
   * @throws MetaException
   */
  @Override
  public void onAddUniqueConstraint(AddUniqueConstraintEvent addUniqueConstraintEvent) throws MetaException {
    List<SQLUniqueConstraint> cols = addUniqueConstraintEvent.getUniqueConstraintCols();
    if (cols.size() > 0) {
      NotificationEvent event =
          new NotificationEvent(0, now(), EventType.ADD_UNIQUECONSTRAINT.toString(), msgFactory
              .buildAddUniqueConstraintMessage(addUniqueConstraintEvent.getUniqueConstraintCols()).toString());
      event.setDbName(cols.get(0).getTable_db());
      event.setTableName(cols.get(0).getTable_name());
      process(event, addUniqueConstraintEvent);
    }
  }

  /***
   * @param addNotNullConstraintEvent add not null constraint event
   * @throws MetaException
   */
  @Override
  public void onAddNotNullConstraint(AddNotNullConstraintEvent addNotNullConstraintEvent) throws MetaException {
    List<SQLNotNullConstraint> cols = addNotNullConstraintEvent.getNotNullConstraintCols();
    if (cols.size() > 0) {
      NotificationEvent event =
          new NotificationEvent(0, now(), EventType.ADD_NOTNULLCONSTRAINT.toString(), msgFactory
              .buildAddNotNullConstraintMessage(addNotNullConstraintEvent.getNotNullConstraintCols()).toString());
      event.setDbName(cols.get(0).getTable_db());
      event.setTableName(cols.get(0).getTable_name());
      process(event, addNotNullConstraintEvent);
    }
  }

  /***
   * @param dropConstraintEvent drop constraint event
   * @throws MetaException
   */
  @Override
  public void onDropConstraint(DropConstraintEvent dropConstraintEvent) throws MetaException {
    String dbName = dropConstraintEvent.getDbName();
    String tableName = dropConstraintEvent.getTableName();
    String constraintName = dropConstraintEvent.getConstraintName();
    NotificationEvent event =
        new NotificationEvent(0, now(), EventType.DROP_CONSTRAINT.toString(), msgFactory
            .buildDropConstraintMessage(dbName, tableName, constraintName).toString());
    event.setDbName(dbName);
    event.setTableName(tableName);
    process(event, dropConstraintEvent);
  }

  /***
   * @param allocWriteIdEvent Alloc write id event
   * @throws MetaException
   */
  @Override
  public void onAllocWriteId(AllocWriteIdEvent allocWriteIdEvent) throws MetaException {
    String tableName = allocWriteIdEvent.getTableName();
    NotificationEvent event =
            new NotificationEvent(0, now(), EventType.ALLOC_WRITE_ID.toString(), msgFactory
                    .buildAllocWriteIdMessage(allocWriteIdEvent.getTxnIds(), tableName).toString());
    event.setTableName(tableName);
    process(event, allocWriteIdEvent);
  }

  private int now() {
    long millis = System.currentTimeMillis();
    millis /= 1000;
    if (millis > Integer.MAX_VALUE) {
      LOG.warn("We've passed max int value in seconds since the epoch, " +
          "all notification times will be the same!");
      return Integer.MAX_VALUE;
    }
    return (int)millis;
  }

  /**
   * Process this notification by adding it to metastore DB.
   *
   * @param event NotificationEvent is the object written to the metastore DB.
   * @param listenerEvent ListenerEvent (from which NotificationEvent was based) used only to set the
   *                      DB_NOTIFICATION_EVENT_ID_KEY_NAME for future reference by other listeners.
   */
  private void process(NotificationEvent event, ListenerEvent listenerEvent) throws MetaException {
    event.setMessageFormat(msgFactory.getMessageFormat());
    LOG.debug("DbNotificationListener: Processing : {}:{}", event.getEventId(),
        event.getMessage());
    HMSHandler.getMSForConf(conf).addNotificationEvent(event);

      // Set the DB_NOTIFICATION_EVENT_ID for future reference by other listeners.
      if (event.isSetEventId()) {
        listenerEvent.putParameter(
            MetaStoreEventListenerConstants.DB_NOTIFICATION_EVENT_ID_KEY_NAME,
            Long.toString(event.getEventId()));
      }
  }

  private static class CleanerThread extends Thread {
    private RawStore rs;
    private int ttl;
    static private long sleepTime = 60000;

    CleanerThread(Configuration conf, RawStore rs) {
      super("CleanerThread");
      this.rs = rs;
      setTimeToLive(MetastoreConf.getTimeVar(conf, ConfVars.EVENT_DB_LISTENER_TTL,
          TimeUnit.SECONDS));
      setDaemon(true);
    }

    @Override
    public void run() {
      while (true) {
        rs.cleanNotificationEvents(ttl);
        rs.cleanWriteNotificationEvents(ttl);
        LOG.debug("Cleaner thread done");
        try {
          Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
          LOG.info("Cleaner thread sleep interrupted", e);
        }
      }
    }

    public void setTimeToLive(long configTtl) {
      if (configTtl > Integer.MAX_VALUE) ttl = Integer.MAX_VALUE;
      else ttl = (int)configTtl;
    }

  }

  // TODO: this needs to be enhanced once change management based filesystem is implemented
  // Currently using fileuri#checksum as the format
  private String encodeFileUri(String fileUriStr, String fileChecksum, String subDir) {
    String result;
    if (fileChecksum != null) {
      result = fileUriStr + "#" + fileChecksum;
    } else {
      result = fileUriStr;
    }

    if (subDir != null) {
      result = result + "#" + subDir;
    }
    return result;
  }
}
