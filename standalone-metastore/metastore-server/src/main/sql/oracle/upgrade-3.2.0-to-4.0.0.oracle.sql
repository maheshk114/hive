SELECT 'Upgrading MetaStore schema from 3.2.0 to 4.0.0' AS Status from dual;

-- HIVE-21336 safeguards from changes user may have made after 3.x schema was installed.
ALTER SESSION SET NLS_LENGTH_SEMANTICS=BYTE;

ALTER TABLE TBLS ADD WRITE_ID number DEFAULT 0 NOT NULL;
ALTER TABLE PARTITIONS ADD WRITE_ID number DEFAULT 0 NOT NULL;

-- HIVE-20793
ALTER TABLE WM_RESOURCEPLAN ADD NS VARCHAR2(128);
UPDATE WM_RESOURCEPLAN SET NS = 'default' WHERE NS IS NULL;
DROP INDEX UNIQUE_WM_RESOURCEPLAN;
CREATE UNIQUE INDEX UNIQUE_WM_RESOURCEPLAN ON WM_RESOURCEPLAN (NS, "NAME");

-- HIVE-21063
CREATE UNIQUE INDEX NOTIFICATION_LOG_EVENT_ID ON NOTIFICATION_LOG(EVENT_ID);

-- HIVE-21337
ALTER TABLE COLUMNS_V2 MODIFY ("COMMENT" VARCHAR2(4000));

-- HIVE-22046 (DEFAULT HIVE)
ALTER TABLE TAB_COL_STATS ADD ENGINE VARCHAR2(128);
UPDATE TAB_COL_STATS SET ENGINE = 'hive' WHERE ENGINE IS NULL;
ALTER TABLE PART_COL_STATS ADD ENGINE VARCHAR2(128);
UPDATE PART_COL_STATS SET ENGINE = 'hive' WHERE ENGINE IS NULL;

CREATE TABLE "SCHEDULED_QUERIES" (
	"SCHEDULED_QUERY_ID" number(19) NOT NULL,
	"CLUSTER_NAMESPACE" VARCHAR(256),
	"ENABLED" NUMBER(1) NOT NULL CHECK ("ENABLED" IN (1,0)),
	"NEXT_EXECUTION" INTEGER,
	"QUERY" VARCHAR(4000),
	"SCHEDULE" VARCHAR(256),
	"SCHEDULE_NAME" VARCHAR(256),
	"USER" VARCHAR(256),
	CONSTRAINT SCHEDULED_QUERIES_PK PRIMARY KEY ("SCHEDULED_QUERY_ID")
);

CREATE TABLE "SCHEDULED_EXECUTIONS" (
	"SCHEDULED_EXECUTION_ID" number(19) NOT NULL,
	"END_TIME" INTEGER,
	"ERROR_MESSAGE" VARCHAR(2000),
	"EXECUTOR_QUERY_ID" VARCHAR(256),
	"LAST_UPDATE_TIME" INTEGER,
	"SCHEDULED_QUERY_ID" number(19),
	"START_TIME" INTEGER,
	"STATE" VARCHAR(256),
	CONSTRAINT SCHEDULED_EXECUTIONS_PK PRIMARY KEY ("SCHEDULED_EXECUTION_ID"),
	CONSTRAINT SCHEDULED_EXECUTIONS_SCHQ_FK FOREIGN KEY ("SCHEDULED_QUERY_ID") REFERENCES "SCHEDULED_QUERIES"("SCHEDULED_QUERY_ID") ON DELETE CASCADE
);

CREATE INDEX IDX_SCHEDULED_EX_LAST_UPDATE ON "SCHEDULED_EXECUTIONS" ("LAST_UPDATE_TIME");
CREATE INDEX IDX_SCHEDULED_EX_SQ_ID ON "SCHEDULED_EXECUTIONS" ("SCHEDULED_QUERY_ID");

-- HIVE-22729
ALTER TABLE COMPACTION_QUEUE ADD CQ_ERROR_MESSAGE CLOB;
ALTER TABLE COMPLETED_COMPACTIONS ADD CC_ERROR_MESSAGE CLOB;

-- HIVE-23683
ALTER TABLE COMPACTION_QUEUE ADD CQ_ENQUEUE_TIME number(19);
ALTER TABLE COMPLETED_COMPACTIONS ADD CC_ENQUEUE_TIME number(19);

-- HIVE-22728
ALTER TABLE KEY_CONSTRAINTS DROP CONSTRAINT CONSTRAINTS_PK;
ALTER TABLE KEY_CONSTRAINTS ADD CONSTRAINT CONSTRAINTS_PK PRIMARY KEY (PARENT_TBL_ID, CONSTRAINT_NAME, POSITION);

-- HIVE-21487
CREATE INDEX COMPLETED_COMPACTIONS_RES ON COMPLETED_COMPACTIONS (CC_DATABASE,CC_TABLE,CC_PARTITION);
-- HIVE-22872
ALTER TABLE SCHEDULED_QUERIES ADD ACTIVE_EXECUTION_ID number(19);

-- HIVE-22995
ALTER TABLE DBS ADD DB_MANAGED_LOCATION_URI VARCHAR2(4000) NULL;

-- HIVE-23107
ALTER TABLE COMPACTION_QUEUE ADD CQ_NEXT_TXN_ID NUMBER(19);

-- HIVE-23048
INSERT INTO TXNS (TXN_ID, TXN_STATE, TXN_STARTED, TXN_LAST_HEARTBEAT, TXN_USER, TXN_HOST)
  SELECT COALESCE(MAX(CTC_TXNID),0), 'c', 0, 0, '_', '_' FROM COMPLETED_TXN_COMPONENTS;
INSERT INTO TXNS (TXN_ID, TXN_STATE, TXN_STARTED, TXN_LAST_HEARTBEAT, TXN_USER, TXN_HOST)
  VALUES (1000000000, 'c', 0, 0, '_', '_');
-- DECLARE max_txn NUMBER;
-- BEGIN
--    SELECT MAX(TXN_ID) + 1 INTO max_txn FROM TXNS;
--    EXECUTE IMMEDIATE 'CREATE SEQUENCE TXNS_TXN_ID_SEQ INCREMENT BY 1 START WITH ' || max_txn || ' CACHE 20';
-- END;
CREATE SEQUENCE TXNS_TXN_ID_SEQ INCREMENT BY 1 START WITH 1000000001 CACHE 20;
ALTER TABLE TXNS MODIFY TXN_ID default TXNS_TXN_ID_SEQ.nextval;

RENAME NEXT_TXN_ID TO TXN_LOCK_TBL;
ALTER TABLE TXN_LOCK_TBL RENAME COLUMN NTXN_NEXT TO TXN_LOCK;

--Create table replication metrics
CREATE TABLE "REPLICATION_METRICS" (
  "RM_SCHEDULED_EXECUTION_ID" number PRIMARY KEY,
  "RM_POLICY" varchar2(256) NOT NULL,
  "RM_DUMP_EXECUTION_ID" number NOT NULL,
  "RM_METADATA" varchar2(4000),
  "RM_PROGRESS" varchar2(4000),
  "RM_START_TIME" integer NOT NULL
);

--Create indexes for the replication metrics table
CREATE INDEX POLICY_IDX ON "REPLICATION_METRICS" ("RM_POLICY");
CREATE INDEX DUMP_IDX ON "REPLICATION_METRICS" ("RM_DUMP_EXECUTION_ID");

-- Create stored procedure tables
CREATE TABLE "STORED_PROCS" (
  "SP_ID" NUMBER NOT NULL,
  "CREATE_TIME" NUMBER(10) NOT NULL,
  "DB_ID" NUMBER NOT NULL,
  "NAME" VARCHAR(256) NOT NULL,
  "OWNER_NAME" VARCHAR(128) NOT NULL,
  "SOURCE" NCLOB NOT NULL,
  PRIMARY KEY ("SP_ID")
);

CREATE UNIQUE INDEX UNIQUESTOREDPROC ON STORED_PROCS ("NAME", "DB_ID");
ALTER TABLE "STORED_PROCS" ADD CONSTRAINT "STOREDPROC_FK1" FOREIGN KEY ("DB_ID") REFERENCES "DBS" ("DB_ID");

-- HIVE-24291
ALTER TABLE COMPACTION_QUEUE ADD CQ_TXN_ID NUMBER(19);

-- HIVE-24275
ALTER TABLE COMPACTION_QUEUE ADD CQ_COMMIT_TIME NUMBER(19);

-- HIVE-24589
CREATE INDEX CTLG_NAME_DBS ON DBS(CTLG_NAME);

-- These lines need to be last.  Insert any changes above.
UPDATE VERSION SET SCHEMA_VERSION='4.0.0', VERSION_COMMENT='Hive release version 4.0.0' where VER_ID=1;
SELECT 'Finished upgrading MetaStore schema from 3.2.0 to 4.0.0' AS Status from dual;

