package com.example.oodbackend.service;

import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService{

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List <Categories> fetchCategoryList(){
        return categoriesRepository.findAll();
    }

    @Override
    public Categories fetchCategoryById(Long categoryId) {
      Optional<Categories> category = categoriesRepository.findById(categoryId);
      return category.get();
    }
}
