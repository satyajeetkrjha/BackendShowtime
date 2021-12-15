package com.example.oodbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCategoryRequest {

    private Long categoryId;
    private Long userId;
}
