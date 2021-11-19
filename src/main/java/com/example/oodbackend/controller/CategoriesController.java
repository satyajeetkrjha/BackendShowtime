package com.example.oodbackend.controller;


import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/categories")
    public List<Categories> fetchCategoryList(){
        return categoriesService.fetchCategoryList();
    }

    @GetMapping("/categories/{id}")
    public Categories fetchCategoryById(@PathVariable("id") Long categoryId){
        return categoriesService.fetchCategoryById(categoryId);
    }







}
