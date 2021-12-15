package com.example.oodbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrendingEvents {
    private Long eventId;
    private String eventName;
    private String eventDescription;
    Date startDate ;
    Date endDate;
    private int totalUsers;
    private String eventCategory;
}
