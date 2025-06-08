package com.priyanshu.patient_service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientServiceApplication implements CommandLineRunner {

	@Value("${spring.app.appUrl}")
	private String appUrl;

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(PatientServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PatientServiceApplication.class, args);
	}

	@Override
	public void run(final String... args){
		log.info("Hello World");
        log.info("Application running at {}", appUrl);
	}
}
