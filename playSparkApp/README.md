# playSparkApp

## Apache Spark Examples

 

### Word Count Examples

This repo also contains the classic word count examples, in Java and Scala, with some minor modifications. 

You can use any text file as an input and in our talk we used the complete works of Shakespeare in text format. The 
download is available here:
 
http://ocw.mit.edu/ans7870/6/6.006/s08/lecturenotes/files/t8.shakespeare.txt
 
```
${SPARK_HOME}/bin/spark-submit \    
--class com.prussia.play.spark.WordCountJava8 \      
--verbose \    
--master 'local[*]' \    
--files "log4j2.xml" \    
--driver-java-options "-Dlog4j.configuration=log4j2.xml" \    
--jars /Users/prussia/github/git/apache-spark-examples/target/apache-spark-examples-1.0.jar
``` 