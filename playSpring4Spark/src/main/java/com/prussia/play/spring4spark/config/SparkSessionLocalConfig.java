package com.prussia.play.spring4spark.config;

import javax.sql.DataSource;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.SparkSession.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = { "local" })
public class SparkSessionLocalConfig {
	
	@Autowired
	private DataSource ds;

	@Bean
	public SparkSession sparkSession() {
		Builder builder = SparkSession.builder();

		return builder.appName("SparkWithSpring").master("local").enableHiveSupport().getOrCreate();
	}
}
