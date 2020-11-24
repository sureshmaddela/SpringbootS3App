package com.ecom.aws.s3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main implementation class which serves two purpose in a spring boot application: Configuration and bootstrapping.
 * @author yatin-batra
 */
@SpringBootApplication
public class SpringbootS3App {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootS3App.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootS3App.class, args);
		LOGGER.info("SpringbootS3tutorial application started successfully.");
	}
}
