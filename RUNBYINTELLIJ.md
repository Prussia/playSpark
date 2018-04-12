# Start by IntelliJ

*Main class:*

org.apache.spark.deploy.SparkSubmit

*VM Options:*
```
-cp <spark_dir>/conf/:<spark_dir>/jars/* -Xmx6g
```
for example, 
```
-cp /Users/XXX/hadoop/spark-2.2.0-bin-hadoop2.7/conf/:/Users/XXX/hadoop/spark-2.2.0-bin-hadoop2.7/jars/*:/Users/XXX/hadoop/spark-2.2.0-bin-hadoop2.7/hadoop-conf/ -Xmx1g
```

*Program arguments:*
```
--master
local[*]
--conf
spark.driver.memory=6G
--class
com.company.MyAppMainClass
--num-executors
8
--executor-memory
2G
<project_dir>/target/scala-2.11/my-spark-app.jar
<my_spark_app_args_if_any>
```
