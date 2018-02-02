CREATE TABLE TXN_TO_WRITE_ID (
  T2W_TXNID bigint,
  T2W_TABLE varchar(256) NOT NULL,
  T2W_WRITEID bigint NOT NULL
);

CREATE TABLE NEXT_WRITE_ID (
  NWI_TABLE varchar(256) NOT NULL,
  NWI_NEXT bigint NOT NULL
);

RENAME COLUMN COMPACTION_QUEUE.CQ_HIGHEST_TXN_ID TO CQ_HIGHEST_WRITE_ID;

RENAME COLUMN COMPLETED_COMPACTIONS.CC_HIGHEST_TXN_ID TO CC_HIGHEST_WRITE_ID;