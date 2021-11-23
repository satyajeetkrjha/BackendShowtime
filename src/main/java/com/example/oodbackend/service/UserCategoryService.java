package com.example.oodbackend.service;


import com.example.oodbackend.dto.UserCategoryRequest;
import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.entity.User;
import com.example.oodbackend.repository.CategoriesRepository;
import com.example.oodbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCategoryService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

    public String saveUserCategory(UserCategoryRequest userCategoryRequest) {
        Categories category1 = categoriesRepository.findById(userCategoryRequest.getCategoryId()).orElse(null);
        User user1 = userRepository.findById(userCategoryRequest.getUserId()).orElse(null);
        user1.getCategories().add(category1);
        userRepository.save(user1);
        return "User Category saved properly";
    }
}
