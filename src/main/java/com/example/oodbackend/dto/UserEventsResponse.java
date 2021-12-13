package com.example.oodbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEventsResponse {
    private Long userId;
    private Long eventId;
    private String eventName;
    private String eventDescription;
    private String firstName;
    private String lastName ;
    private String username ;
}
