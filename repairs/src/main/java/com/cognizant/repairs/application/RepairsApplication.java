package com.cognizant.repairs.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.cognizant.repairs.application", "com.cognizant.repairs.connection", "com.cognizant.repairs.controller", "com.cognizant.repairs.dao", "com.cognizant.repairs.model", "com.cognizant.repairs.service", "com.cognizant.repairs.exception", "com.cognizant.repairs.security"})
public class RepairsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepairsApplication.class, args);
	}

}
