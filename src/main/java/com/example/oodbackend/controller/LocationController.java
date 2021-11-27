package com.example.oodbackend.controller;


import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.entity.Location;
import com.example.oodbackend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import javax.validation.Valid;
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
    @GetMapping("/locations")
    public List<Location> fetchAllLocations(){
       return locationService.fetchAllLocations();
    }

}
