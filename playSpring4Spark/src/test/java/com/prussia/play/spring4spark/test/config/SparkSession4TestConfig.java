package com.prussia.play.spring4spark.test.config;

import org.apache.spark.sql.SparkSession;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class SparkSession4TestConfig {
	@Bean
	public SparkSession sparkSession() {
		return SparkSession
				.builder()
				.config("spark.ui.port", "4041")
				.config("spark.sql.shuffle.partitions", 6)
				.config("spark.executor.memory", "1g")
				.appName("Spring4SparkTest")
				.master("local")
				.enableHiveSupport()
				.getOrCreate();
	}
}
