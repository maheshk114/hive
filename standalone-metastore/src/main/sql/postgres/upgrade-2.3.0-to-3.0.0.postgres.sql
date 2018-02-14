SELECT 'Upgrading MetaStore schema from 2.3.0 to 3.0.0';

--\i 040-HIVE-16556.postgres.sql;
CREATE TABLE "METASTORE_DB_PROPERTIES"
(
  "PROPERTY_KEY" VARCHAR(255) NOT NULL,
  "PROPERTY_VALUE" VARCHAR(1000) NOT NULL,
  "DESCRIPTION" VARCHAR(1000)
);

ALTER TABLE ONLY "METASTORE_DB_PROPERTIES"
  ADD CONSTRAINT "PROPERTY_KEY_PK" PRIMARY KEY ("PROPERTY_KEY");

--\i 041-HIVE-16575.postgres.sql;
CREATE INDEX "CONSTRAINTS_CONSTRAINT_TYPE_INDEX" ON "KEY_CONSTRAINTS" USING BTREE ("CONSTRAINT_TYPE");

--\i 042-HIVE-16922.postgres.sql;
UPDATE "SERDE_PARAMS"
SET "PARAM_KEY"='collection.delim'
WHERE "PARAM_KEY"='colelction.delim';

--\i 043-HIVE-16997.postgres.sql;
ALTER TABLE "PART_COL_STATS" ADD COLUMN "BIT_VECTOR" BYTEA;
ALTER TABLE "TAB_COL_STATS" ADD COLUMN "BIT_VECTOR" BYTEA;

--\i 044-HIVE-16886.postgres.sql;
INSERT INTO "NOTIFICATION_SEQUENCE" ("NNI_ID", "NEXT_EVENT_ID") SELECT 1,1 WHERE NOT EXISTS ( SELECT "NEXT_EVENT_ID" FROM "NOTIFICATION_SEQUENCE");

--\i 045-HIVE-17566.postgres.sql;
CREATE TABLE "WM_RESOURCEPLAN" (
    "RP_ID" bigint NOT NULL,
    "NAME" character varying(128) NOT NULL,
    "QUERY_PARALLELISM" integer,
    "STATUS" character varying(20) NOT NULL,
    "DEFAULT_POOL_ID" bigint
);

ALTER TABLE ONLY "WM_RESOURCEPLAN"
    ADD CONSTRAINT "WM_RESOURCEPLAN_pkey" PRIMARY KEY ("RP_ID");

ALTER TABLE ONLY "WM_RESOURCEPLAN"
    ADD CONSTRAINT "UNIQUE_WM_RESOURCEPLAN" UNIQUE ("NAME");


CREATE TABLE "WM_POOL" (
    "POOL_ID" bigint NOT NULL,
    "RP_ID" bigint NOT NULL,
    "PATH" character varying(1024) NOT NULL,
    "ALLOC_FRACTION" double precision,
    "QUERY_PARALLELISM" integer,
    "SCHEDULING_POLICY" character varying(1024)
);

ALTER TABLE ONLY "WM_POOL"
    ADD CONSTRAINT "WM_POOL_pkey" PRIMARY KEY ("POOL_ID");

ALTER TABLE ONLY "WM_POOL"
    ADD CONSTRAINT "UNIQUE_WM_POOL" UNIQUE ("RP_ID", "PATH");

ALTER TABLE ONLY "WM_POOL"
    ADD CONSTRAINT "WM_POOL_FK1" FOREIGN KEY ("RP_ID") REFERENCES "WM_RESOURCEPLAN" ("RP_ID") DEFERRABLE;
ALTER TABLE ONLY "WM_RESOURCEPLAN"
    ADD CONSTRAINT "WM_RESOURCEPLAN_FK1" FOREIGN KEY ("DEFAULT_POOL_ID") REFERENCES "WM_POOL" ("POOL_ID") DEFERRABLE;


CREATE TABLE "WM_TRIGGER" (
    "TRIGGER_ID" bigint NOT NULL,
    "RP_ID" bigint NOT NULL,
    "NAME" character varying(128) NOT NULL,
    "TRIGGER_EXPRESSION" character varying(1024) DEFAULT NULL::character varying,
    "ACTION_EXPRESSION" character varying(1024) DEFAULT NULL::character varying,
    "IS_IN_UNMANAGED" boolean NOT NULL DEFAULT false
);

ALTER TABLE ONLY "WM_TRIGGER"
    ADD CONSTRAINT "WM_TRIGGER_pkey" PRIMARY KEY ("TRIGGER_ID");

ALTER TABLE ONLY "WM_TRIGGER"
    ADD CONSTRAINT "UNIQUE_WM_TRIGGER" UNIQUE ("RP_ID", "NAME");

ALTER TABLE ONLY "WM_TRIGGER"
    ADD CONSTRAINT "WM_TRIGGER_FK1" FOREIGN KEY ("RP_ID") REFERENCES "WM_RESOURCEPLAN" ("RP_ID") DEFERRABLE;


CREATE TABLE "WM_POOL_TO_TRIGGER" (
    "POOL_ID" bigint NOT NULL,
    "TRIGGER_ID" bigint NOT NULL
);

ALTER TABLE ONLY "WM_POOL_TO_TRIGGER"
    ADD CONSTRAINT "WM_POOL_TO_TRIGGER_pkey" PRIMARY KEY ("POOL_ID", "TRIGGER_ID");

ALTER TABLE ONLY "WM_POOL_TO_TRIGGER"
    ADD CONSTRAINT "WM_POOL_TO_TRIGGER_FK1" FOREIGN KEY ("POOL_ID") REFERENCES "WM_POOL" ("POOL_ID") DEFERRABLE;

ALTER TABLE ONLY "WM_POOL_TO_TRIGGER"
    ADD CONSTRAINT "WM_POOL_TO_TRIGGER_FK2" FOREIGN KEY ("TRIGGER_ID") REFERENCES "WM_TRIGGER" ("TRIGGER_ID") DEFERRABLE;


CREATE TABLE "WM_MAPPING" (
    "MAPPING_ID" bigint NOT NULL,
    "RP_ID" bigint NOT NULL,
    "ENTITY_TYPE" character varying(128) NOT NULL,
    "ENTITY_NAME" character varying(128) NOT NULL,
    "POOL_ID" bigint,
    "ORDERING" integer
);

ALTER TABLE ONLY "WM_MAPPING"
    ADD CONSTRAINT "WM_MAPPING_pkey" PRIMARY KEY ("MAPPING_ID");

ALTER TABLE ONLY "WM_MAPPING"
    ADD CONSTRAINT "UNIQUE_WM_MAPPING" UNIQUE ("RP_ID", "ENTITY_TYPE", "ENTITY_NAME");

ALTER TABLE ONLY "WM_MAPPING"
    ADD CONSTRAINT "WM_MAPPING_FK1" FOREIGN KEY ("RP_ID") REFERENCES "WM_RESOURCEPLAN" ("RP_ID") DEFERRABLE;

ALTER TABLE ONLY "WM_MAPPING"
    ADD CONSTRAINT "WM_MAPPING_FK2" FOREIGN KEY ("POOL_ID") REFERENCES "WM_POOL" ("POOL_ID") DEFERRABLE;

UPDATE "VERSION" SET "SCHEMA_VERSION"='3.0.0', "VERSION_COMMENT"='Hive release version 3.0.0' where "VER_ID"=1;
SELECT 'Finished upgrading MetaStore schema from 2.3.0 to 3.0.0';

-- 047-HIVE-14498
CREATE TABLE "MV_CREATION_METADATA" (
    "MV_CREATION_METADATA_ID" bigint NOT NULL,
    "DB_NAME" character varying(128) NOT NULL,
    "TBL_NAME" character varying(256) NOT NULL,
    "TXN_LIST" text
);

CREATE TABLE "MV_TABLES_USED" (
    "MV_CREATION_METADATA_ID" bigint NOT NULL,
    "TBL_ID" bigint NOT NULL
);

ALTER TABLE ONLY "MV_CREATION_METADATA"
    ADD CONSTRAINT "MV_CREATION_METADATA_PK" PRIMARY KEY ("MV_CREATION_METADATA_ID");

CREATE INDEX "MV_UNIQUE_TABLE"
    ON "MV_CREATION_METADATA" USING btree ("TBL_NAME", "DB_NAME");

ALTER TABLE ONLY "MV_TABLES_USED"
    ADD CONSTRAINT "MV_TABLES_USED_FK1" FOREIGN KEY ("MV_CREATION_METADATA_ID") REFERENCES "MV_CREATION_METADATA" ("MV_CREATION_METADATA_ID") DEFERRABLE;

ALTER TABLE ONLY "MV_TABLES_USED"
    ADD CONSTRAINT "MV_TABLES_USED_FK2" FOREIGN KEY ("TBL_ID") REFERENCES "TBLS" ("TBL_ID") DEFERRABLE;

ALTER TABLE COMPLETED_TXN_COMPONENTS ADD COLUMN CTC_TIMESTAMP timestamp NULL;

UPDATE COMPLETED_TXN_COMPONENTS SET CTC_TIMESTAMP = CURRENT_TIMESTAMP;

ALTER TABLE COMPLETED_TXN_COMPONENTS ALTER COLUMN CTC_TIMESTAMP SET NOT NULL;

ALTER TABLE COMPLETED_TXN_COMPONENTS ALTER COLUMN CTC_TIMESTAMP SET DEFAULT CURRENT_TIMESTAMP;

CREATE INDEX COMPLETED_TXN_COMPONENTS_INDEX ON COMPLETED_TXN_COMPONENTS USING btree (CTC_DATABASE, CTC_TABLE, CTC_PARTITION);

-- 048-HIVE-18489
UPDATE "FUNC_RU"
  SET "RESOURCE_URI" = 's3a' || SUBSTR("RESOURCE_URI", 4)
  WHERE "RESOURCE_URI" LIKE 's3n://%' ;

UPDATE "SKEWED_COL_VALUE_LOC_MAP"
  SET "LOCATION" = 's3a' || SUBSTR("LOCATION", 4)
  WHERE "LOCATION" LIKE 's3n://%' ;

UPDATE "SDS"
  SET "LOCATION" = 's3a' || SUBSTR("LOCATION", 4)
  WHERE "LOCATION" LIKE 's3n://%' ;

UPDATE "DBS"
  SET "DB_LOCATION_URI" = 's3a' || SUBSTR("DB_LOCATION_URI", 4)
  WHERE "DB_LOCATION_URI" LIKE 's3n://%' ;

CREATE TABLE TXN_TO_WRITE_ID (
  T2W_TXNID bigint,
  T2W_DATABASE varchar(128) NOT NULL,
  T2W_TABLE varchar(256) NOT NULL,
  T2W_WRITEID bigint NOT NULL
);

CREATE INDEX TXN_TO_WRITE_ID_IDX ON TXN_TO_WRITE_ID (T2W_TXNID);

CREATE TABLE NEXT_WRITE_ID (
  NWI_DATABASE varchar(128) NOT NULL,
  NWI_TABLE varchar(256) NOT NULL,
  NWI_NEXT bigint NOT NULL
);

CREATE UNIQUE INDEX NEXT_WRITE_ID_IDX ON NEXT_WRITE_ID (NWI_DATABASE, NWI_TABLE);

ALTER TABLE COMPACTION_QUEUE RENAME CQ_HIGHEST_TXN_ID TO CQ_HIGHEST_WRITE_ID;

ALTER TABLE COMPLETED_COMPACTIONS RENAME CC_HIGHEST_TXN_ID TO CC_HIGHEST_WRITE_ID;
