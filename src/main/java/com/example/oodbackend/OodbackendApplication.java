package com.example.oodbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// this is God level fix so you respect this file Satya
@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
public class OodbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OodbackendApplication.class, args);
	}

}
