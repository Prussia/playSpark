package com.prussia.play.spring4spark.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import static org.apache.spark.sql.functions.max;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	}
}
