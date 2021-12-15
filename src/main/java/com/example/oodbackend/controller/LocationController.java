package com.example.oodbackend.controller;


import com.example.oodbackend.dto.UserLocationRequest;
import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.entity.Location;
import com.example.oodbackend.entity.User;

import com.example.oodbackend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@CrossOrigin
@RestController
@RequestMapping("/api/showtime")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/location/{id}")
    public Location fetchLocationById(@PathVariable("id") Long locationId){
        return locationService.fetchLocationById(locationId);
    }

    @PostMapping("/location")
    public Location saveLocation(@Valid @RequestBody Location location){

        return locationService.saveLocation(location);
    }


    @PostMapping("/changelocation")
    public ResponseEntity<String> changeLocation(@Valid @RequestBody UserLocationRequest userLocationRequest){
        locationService.changeLocation(userLocationRequest);
        return new ResponseEntity<>("Location Changed Successfully",
                OK);
    }

    @GetMapping("/locations")
    public List<Location> fetchAllLocations(){
        return locationService.fetchAllLocations();
    }

}