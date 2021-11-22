
package com.example.oodbackend.service;


import com.example.oodbackend.dto.RegisterRequest;
import com.example.oodbackend.repository.UserRepository;
import com.example.oodbackend.service.LocationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.oodbackend.entity.User;
import com.example.oodbackend.entity.Location;
import static java.time.Instant.now;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;




@Service
public class AuthService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Autowired
    private LocationService locationService;

    @Transactional
    public void signup(RegisterRequest registerRequest) {

        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreatedAt(now());
        user.setStatus(false);
        Location location = locationService.fetchLocationById(registerRequest.getLocationId());
        userRepository.save(user);

    }
}
