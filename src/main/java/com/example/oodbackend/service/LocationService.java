package com.example.oodbackend.service;

import com.example.oodbackend.entity.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {
    public Location fetchLocationById(Long locationId);

     public  Location saveLocation(Location location);

     public List<Location> fetchAllLocations();
}
