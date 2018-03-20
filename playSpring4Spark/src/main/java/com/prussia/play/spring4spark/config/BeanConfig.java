package com.prussia.play.spring4spark.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prussia.play.spring4spark.config.prop.SparkProperties;

@Configuration
public class BeanConfig {

	@Bean
	public SparkProperties sparkProperties() {
		return new SparkProperties();
	}
}
