package com.example.oodbackend.service;

import com.example.oodbackend.entity.Categories;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoriesService {

    public List<Categories> fetchCategoryList();
}
