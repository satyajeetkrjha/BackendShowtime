package com.example.oodbackend.service;


import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.entity.Location;
import com.example.oodbackend.repository.CategoriesRepository;
import com.example.oodbackend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepositoryy;

    @Override
    public Location fetchLocationById(Long locationId) {
        Optional<Location> location = locationRepositoryy.findById(locationId);
        return location.get();
    }
    @Override
    public Location saveLocation(Location location) {
        return locationRepositoryy.save(location);
    }
}
