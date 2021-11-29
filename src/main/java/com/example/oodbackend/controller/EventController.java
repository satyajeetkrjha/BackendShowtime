package com.example.oodbackend.controller;

import com.example.oodbackend.dto.EventsRequest;
import com.example.oodbackend.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



}
