package com.example.oodbackend.service;


import com.example.oodbackend.dto.CategoriesResponse;
import com.example.oodbackend.dto.UserCategoryRequest;
import com.example.oodbackend.dto.UserCategoryResponse;
import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.entity.User;
import com.example.oodbackend.repository.CategoriesRepository;
import com.example.oodbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public List <UserCategoryResponse> getUserByCategory(Long categoryId) {
        Categories category1 = categoriesRepository.findById(categoryId).orElse(null);
          Set <User> users = category1.getUsers();
        List <UserCategoryResponse> temp = new ArrayList<>();
          for(User user :users) {
              UserCategoryResponse userCategoryResponse = new UserCategoryResponse();
              userCategoryResponse.setUserId(user.getUserId());
              userCategoryResponse.setUsername(user.getUsername());
              userCategoryResponse.setFirstName(user.getFirstName());
              userCategoryResponse.setLastName(user.getLastName());

              temp.add(userCategoryResponse);

          }
          System.out.print(temp);
        return temp;
    }

    public List<CategoriesResponse> getCategoriesForUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        Set <Categories> categories = user.getCategories();
        List <CategoriesResponse > temp = new ArrayList<>();
        for (Categories item :categories){
            CategoriesResponse categoriesResponse = new CategoriesResponse();
            categoriesResponse.setCategoryId(item.getCategoryId());
            categoriesResponse.setCategoryName(item.getCategoryName());
            categoriesResponse.setCategoryDescription(item.getCategoryDescription());
            temp.add(categoriesResponse);
        }
        return temp;

    }
}
