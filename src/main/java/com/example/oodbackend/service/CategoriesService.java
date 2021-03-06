package com.example.oodbackend.service;

import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.entity.Location;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoriesService {

    public List<Categories> fetchCategoryList();

    public Categories fetchCategoryById(Long categoryId);

    public Categories savecategory(Categories categories);
}
