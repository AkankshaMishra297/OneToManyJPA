package com.neo.spring.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);


	public static void main(String[] args) {
		
		
		LOGGER.info("Starting main() from Application with arguments:: dashboardRequest: ");

		SpringApplication.run(Application.class, args);
		
		LOGGER.info("Exiting main() from Application with arguments:: dashboardRequest: ");

	}

}
