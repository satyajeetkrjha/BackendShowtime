package com.example.oodbackend.controller;

import com.example.oodbackend.dto.EventLocationResponse;
import com.example.oodbackend.dto.EventsRequest;
import com.example.oodbackend.entity.Events;
import com.example.oodbackend.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  java.util.*;
import static org.springframework.http.HttpStatus.OK;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class EventController {

    @Autowired
    private EventsService eventsService;

    @PostMapping("/events")
    private ResponseEntity<String> saveEvents(@RequestBody EventsRequest eventsRequest){
        eventsService.saveEvents(eventsRequest);
        return new ResponseEntity<>("Event saved Successful",
                OK);
    }

    @GetMapping("events")
    public List<EventLocationResponse> getEventsByCategoryAndLocation(@RequestParam(value="category") Long category ,
                                                                    @RequestParam(value="location") Long location){
        return eventsService.getEventsByLocationCategory(category,location);

    }



}
