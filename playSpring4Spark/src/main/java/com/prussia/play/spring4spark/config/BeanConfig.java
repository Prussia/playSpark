package com.prussia.play.spring4spark.config;

import com.prussia.play.spring4spark.config.prop.SparkProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public SparkProperties sparkProperties() {
        return new SparkProperties();
    }
}
