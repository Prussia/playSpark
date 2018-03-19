package com.prussia.play.spring4spark.config;

import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = { "local" })
public class SparkSessionLocalConfig {
	@Bean
	public SparkSession sparkSession() {
		return SparkSession
				.builder()
				.appName("SparkWithSpring")
				.master("local")
				.enableHiveSupport()
				.getOrCreate();
	}
}
