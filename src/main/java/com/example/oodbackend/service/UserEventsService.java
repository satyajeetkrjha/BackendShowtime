package com.example.oodbackend.service;


import com.example.oodbackend.repository.EventsRepository;
import com.example.oodbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oodbackend.entity.User;
import com.example.oodbackend.entity.Events;


@Service
public class UserEventsService {

    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private UserRepository userRepository;


    public void saveUserWithEvents(Long userId, Long eventId) {
        User user = userRepository.findById(userId).orElse(null);
        Events event  = eventsRepository.findById(eventId).orElse(null);
        user.getEvents().add(event);
        userRepository.save(user);
    }
}
