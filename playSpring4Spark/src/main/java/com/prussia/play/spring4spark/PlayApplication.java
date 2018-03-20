package com.prussia.play.spring4spark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prussia.play.spring4spark.service.SparkAppService;

@SpringBootApplication
public class PlayApplication implements CommandLineRunner {
	
	@Autowired
	private SparkAppService sparkAppService;

	public static void main(String[] args) {
		SpringApplication.run(PlayApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		//sparkAppService.getMaxScore();
	}		
	
}
