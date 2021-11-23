package com.example.oodbackend.controller;

import com.example.oodbackend.dto.UserCategoryRequest;
import com.example.oodbackend.entity.Location;
import com.example.oodbackend.service.UserCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

}
