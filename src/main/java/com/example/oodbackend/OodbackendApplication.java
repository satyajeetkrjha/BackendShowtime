package com.example.oodbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({ "com.controller.AuthController, com.controller.HelloController, com.controller.CategoriesController, com.controller.LocationController"})
// If our Controller class or Service class is not in the same packages we have //to add packages's name like this...directory(package) with main class
public class OodbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OodbackendApplication.class, args);
	}

}
