package com.prussia.play.spring4spark.service;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.max;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prussia.play.spring4spark.entity.Person;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class SparkAppService {
	@Autowired
	private SparkSession sparkSession;
	
	public int getMaxScore() {
		log.info("Processing started...");
		Dataset<Row> scoresDf = sparkSession.read().table("scores");
		int result = scoresDf.agg(max("score")).collectAsList().get(0).getInt(0);
		log.info("Result is: " + result);
		log.info("Processing completed...");
		return result;
	}
	
	public void printDataFrames() {
		Dataset<Row> df = sparkSession.read().json("./src/main/resources/people.json");
		
		df.show();
		df.printSchema();
		df.select("name").show();
		df.select(col("name"), col("age").plus(1)).show();
		df.filter(col("age").gt(21)).show();
		df.groupBy("age").count().show();
	}
	
	public void printDFbySQL() {
//		sparkSession.read().jdbc(url, table, properties)
		Dataset<Row> df = sparkSession.read().json("./src/main/resources/people.json");
		
		df.createOrReplaceTempView("people");

		Dataset<Row> sqlDF = sparkSession.sql("SELECT * FROM people");
		sqlDF.show();
	}
	
	public void printDFRDD() {
		JavaRDD<Person> peopleRDD = sparkSession.read()
				  .textFile("./src/main/resources/people.txt")
				  .javaRDD()
				  .map(line -> {
				    String[] parts = line.split(",");
				    Person person = new Person();
				    person.setName(parts[0]);
				    person.setAge(Integer.parseInt(parts[1].trim()));
				    return person;
				  });
		
		// Apply a schema to an RDD of JavaBeans to get a DataFrame
		Dataset<Row> peopleDF = sparkSession.createDataFrame(peopleRDD, Person.class);
		// Register the DataFrame as a temporary view
		peopleDF.createOrReplaceTempView("people");
	}
}
