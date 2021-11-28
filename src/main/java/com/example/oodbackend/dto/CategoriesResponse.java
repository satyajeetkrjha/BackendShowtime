package com.example.oodbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesResponse {
    private String categoryName;
    private Long categoryId;
    private String categoryDescription;

}
