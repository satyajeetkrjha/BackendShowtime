package com.example.oodbackend.controller;


import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.entity.Location;
import com.example.oodbackend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/location/{id}")
    public Location fetchLocationById(@PathVariable("id") Long locationId){
        return locationService.fetchLocationById(locationId);
    }

}
