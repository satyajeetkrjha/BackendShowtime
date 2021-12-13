package com.example.oodbackend.controller;


import com.example.oodbackend.dto.InterestedRequest;
import com.example.oodbackend.service.UserEventsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
}
