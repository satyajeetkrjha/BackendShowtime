package com.example.oodbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventsFollowedByAUser {

    private Long eventId;
    private String eventName;
    private String eventDescription;


}
