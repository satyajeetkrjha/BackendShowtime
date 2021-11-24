package com.example.oodbackend;

import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.entity.User;
import com.example.oodbackend.repository.CategoriesRepository;
import com.example.oodbackend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import java.util.*;
import java.util.Arrays;
import java.util.Optional;

// this is God level fix so you respect this file Satya
@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
@EnableAsync
public class OodbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OodbackendApplication.class, args);
	}

	/*
	@Bean
	public CommandLineRunner mappingDemo(UserRepository userRepository,
										 CategoriesRepository categoriesRepository) {
		return args -> {

			Categories category1 = categoriesRepository.findById(Long.valueOf(6)).orElse(null);
			category1.getUsers();
			System.out.println(category1.getUsers());

		};
	}

	 */


}
