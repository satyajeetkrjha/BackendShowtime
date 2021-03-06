package com.example.oodbackend.controller;


import com.example.oodbackend.dto.CategoriesResponse;
import com.example.oodbackend.dto.UserCategoryResponse;
import com.example.oodbackend.dto.CategoriesResponse;
import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.entity.Location;
import com.example.oodbackend.entity.User;
import com.example.oodbackend.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/categories")
    public List<CategoriesResponse> fetchCategoryList(){
        List <Categories> categories = categoriesService.fetchCategoryList();
        List <CategoriesResponse> temp = new ArrayList<>();
        for(Categories category :categories) {
            CategoriesResponse CategoryResponse = new CategoriesResponse();
            CategoryResponse.setCategoryId(category.getCategoryId());
            CategoryResponse.setCategoryName(category.getCategoryName());
            CategoryResponse.setCategoryDescription(category.getCategoryDescription());
            temp.add(CategoryResponse);

        }

       return temp;
    }

    @GetMapping("/categories/{id}")
    public Categories fetchCategoryById(@PathVariable("id") Long categoryId){
        return categoriesService.fetchCategoryById(categoryId);
    }
    @PostMapping("/categories")
    public Categories saveCategories(@Valid @RequestBody Categories categories){

        return categoriesService.savecategory(categories);
    }

}
