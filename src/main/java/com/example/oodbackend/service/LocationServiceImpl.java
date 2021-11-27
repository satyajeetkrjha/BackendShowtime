package com.example.oodbackend.service;


import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.entity.Location;
import com.example.oodbackend.repository.CategoriesRepository;
import com.example.oodbackend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location fetchLocationById(Long locationId) {
        Optional<Location> location = locationRepository.findById(locationId);
        return location.get();
    }

    @Override
    public List<Location> fetchAllLocations(){
        List<Location> locations = locationRepository.findAll();
        return locations;
    }

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }
}
