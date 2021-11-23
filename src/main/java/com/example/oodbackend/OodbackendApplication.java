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

import java.util.Arrays;
import java.util.Optional;

// this is God level fix so you respect this file Satya
@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
@EnableAsync
public class OodbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OodbackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(CategoriesRepository categoriesRepository,
										 UserRepository userRepository) {
		return args -> {

            Long categoryId = Long.valueOf(6);
			Categories category1 =categoriesRepository.findById(categoryId).get();


			Long userId = Long.valueOf(3);
			User user1 = userRepository.findById(userId).get();


			System.out.println(category1);
			System.out.println(user1);


			user1.getCategories().add(category1);
			userRepository.save(user1);



		};
	}

}
