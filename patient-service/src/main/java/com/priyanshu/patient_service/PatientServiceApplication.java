package com.priyanshu.patient_service;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientServiceApplication implements CommandLineRunner {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(PatientServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PatientServiceApplication.class, args);
	}

	@Override
	public void run(final String... args){
		log.info("Hello World");
	}
}
