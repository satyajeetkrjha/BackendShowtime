package com.example.oodbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName ;
    private String lastName;
    private String email;
    private String password;
    private String status;
    private String username;
    private long  locationId;
}