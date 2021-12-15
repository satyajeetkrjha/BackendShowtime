package com.example.oodbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCategoryResponse {
   private Long userId;
   private String firstName;
   private String lastName ;
   private String username ;
}
