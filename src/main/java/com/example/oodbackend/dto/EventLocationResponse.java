package com.example.oodbackend.dto;

import com.example.oodbackend.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventLocationResponse {
    private Long eventId;
    private String eventName ;
    private String eventDescription;
    Date startDate ;
    Date endDate;


}
