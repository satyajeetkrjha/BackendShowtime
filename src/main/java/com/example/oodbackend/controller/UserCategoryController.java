package com.example.oodbackend.controller;

import com.example.oodbackend.dto.UserCategoryRequest;
import com.example.oodbackend.dto.UserCategoryResponse;
import com.example.oodbackend.entity.User;
import com.example.oodbackend.service.UserCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
@RestController
@AllArgsConstructor
@RequestMapping("/api/showtime")
public class UserCategoryController {

    @Autowired
    private UserCategoryService userCategoryService;


    @PostMapping("/usercategory")
    public String saveUserCategory(@Valid @RequestBody UserCategoryRequest userCategoryRequest){

        return userCategoryService.saveUserCategory(userCategoryRequest);
    }


    @GetMapping("/getusercategories/{id}")
    public List<UserCategoryResponse> getUserByCategory(@PathVariable("id") Long  categoryId){
       return userCategoryService.getUserByCategory(categoryId);
    }

}
