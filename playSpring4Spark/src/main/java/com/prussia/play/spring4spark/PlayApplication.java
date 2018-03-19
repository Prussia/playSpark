package com.prussia.play.spring4spark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlayApplication implements CommandLineRunner {
	
	@Autowired
	private SparkAppService application;

	public static void main(String[] args) {
		SpringApplication.run(PlayApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		application.process();
	}		
	
}