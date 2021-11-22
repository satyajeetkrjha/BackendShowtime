package com.example.oodbackend.service;

import com.example.oodbackend.entity.Location;
import org.springframework.stereotype.Service;

@Service
public interface LocationService {
    public Location fetchLocationById(Long locationId);

    public Location saveLocation(Location location);
}
