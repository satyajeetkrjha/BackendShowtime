package com.example.oodbackend.controller;


import com.example.oodbackend.dto.*;
import com.example.oodbackend.service.UserEventsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/showtime")
public class UserEventsController {


    @Autowired
    private UserEventsService userEventsService;

    @PostMapping("/interested")
    public ResponseEntity<String> saveUserEvents(@Valid @RequestBody InterestedRequest interestedRequest){
        userEventsService.saveUserWithEvents(interestedRequest.getUserId(),interestedRequest.getEventId());
        return new ResponseEntity<>("Event marked interested by User",
                OK);
    }

    @GetMapping("/interested/{id}")
    public List<UserEventsResponse> getUserByEvent(@PathVariable("id") Long  eventId){
        return userEventsService.getUsersWithAnEvent(eventId);
    }




    @GetMapping("/eventsfollowed/{id}")
    public List<EventsFollowedByAUser> getEventsFollowedByAUser(@PathVariable("id") Long userId){
        return userEventsService.getEventsForUser(userId);
    }


    @GetMapping("/trendingevents")
    public List <TrendingEvents> getTrendingEvents(){
        return userEventsService.getTrendingEvents();


    }





}
