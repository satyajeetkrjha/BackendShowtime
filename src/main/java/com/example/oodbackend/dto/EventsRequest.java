package com.example.oodbackend.dto;


import com.example.oodbackend.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventsRequest {

    private String eventName ;
    private String eventDescription;
    private Long locationId ;
    Date startDate ;
    Date endDate;
    private Long categoryId;
}
