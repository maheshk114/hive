--! qt:dataset:src
--! qt:dataset:part
SET hive.vectorized.execution.enabled=false;
set hive.mapred.mode=nonstrict;
SET hive.auto.convert.join=false;
SET hive.auto.convert.anti.join=true;
-- SORT_QUERY_RESULTS

create table t1_n55 as select cast(key as int) key, value from src where key <= 10;

select * from t1_n55 sort by key;

create table t2_n33 as select cast(2*key as int) key, value from t1_n55;

select * from t2_n33 sort by key;

create table t3_n12 as select * from (select * from t1_n55 union all select * from t2_n33) b;
select * from t3_n12 sort by key, value;

explain select a.key, a.value from t1_n55 a where not exists (select 1 from  t2_n33 b where a.key=b.key) sort by a.key, a.value;
explain cbo select a.key, a.value from t1_n55 a where not exists (select 1 from  t2_n33 b where a.key=b.key) sort by a.key, a.value;
select a.key, a.value from t1_n55 a where not exists (select 1 from  t2_n33 b where a.key=b.key) sort by a.key, a.value;

explain select a.key, a.value from t1_n55 a left join t2_n33 b on a.key=b.key where b.key is null;
explain cbo select a.key, a.value from t1_n55 a left join t2_n33 b on a.key=b.key where b.key is null;
select a.key, a.value from t1_n55 a left join t2_n33 b on a.key=b.key where b.key is null;

explain select a.key, a.value from t1_n55 a left join t2_n33 b on a.key=b.key join t3_n12 c on a.key=c.key where b.key is null  sort by a.key, a.value;
explain cbo select a.key, a.value from t1_n55 a left join t2_n33 b on a.key=b.key join t3_n12 c on a.key=c.key where b.key is null  sort by a.key, a.value;
select a.key, a.value from t1_n55 a left join t2_n33 b on a.key=b.key join t3_n12 c on a.key=c.key where b.key is null  sort by a.key, a.value;

SET hive.vectorized.execution.enabled=true;
SET hive.auto.convert.join=true;
explain select a.key, a.value from t1_n55 a where not exists (select 1 from  t2_n33 b where a.key=b.key) sort by a.key, a.value;
explain cbo select a.key, a.value from t1_n55 a where not exists (select 1 from  t2_n33 b where a.key=b.key) sort by a.key, a.value;
select a.key, a.value from t1_n55 a where not exists (select 1 from  t2_n33 b where a.key=b.key) sort by a.key, a.value;

explain select a.key, a.value from t1_n55 a left join t2_n33 b on a.key=b.key where b.key is null;
explain cbo select a.key, a.value from t1_n55 a left join t2_n33 b on a.key=b.key where b.key is null;
select a.key, a.value from t1_n55 a left join t2_n33 b on a.key=b.key where b.key is null;

explain select a.key, a.value from t1_n55 a left join t2_n33 b on a.key=b.key join t3_n12 c on a.key=c.key where b.key is null  sort by a.key, a.value;
explain cbo select a.key, a.value from t1_n55 a left join t2_n33 b on a.key=b.key join t3_n12 c on a.key=c.key where b.key is null  sort by a.key, a.value;
select a.key, a.value from t1_n55 a left join t2_n33 b on a.key=b.key join t3_n12 c on a.key=c.key where b.key is null  sort by a.key, a.value;

