package com.example.oodbackend.service;


import com.example.oodbackend.dto.UserLocationRequest;
import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.entity.Location;
import com.example.oodbackend.entity.User;

import com.example.oodbackend.repository.CategoriesRepository;
import com.example.oodbackend.repository.LocationRepository;
import com.example.oodbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private UserRepository userRepository;

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
    public User changeLocation(UserLocationRequest userLocationRequest){
        User user = userRepository.findById(userLocationRequest.getUserId()).orElse(null);
        Location location  = locationRepository.findById(userLocationRequest.getLocationId()).orElse(null);
        user.setLocation(location);
        userRepository.save(user);
        return user;
    }

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }
}