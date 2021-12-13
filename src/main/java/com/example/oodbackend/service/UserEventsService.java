package com.example.oodbackend.service;


import com.example.oodbackend.dto.UserCategoryResponse;
import com.example.oodbackend.dto.UserEventsResponse;
import com.example.oodbackend.repository.EventsRepository;
import com.example.oodbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oodbackend.entity.User;
import com.example.oodbackend.entity.Events;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


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

    public List<UserEventsResponse> getUsersWithAnEvent(Long eventId) {
        Events event = eventsRepository.findById(eventId).orElse(null);
        Set<User> users = event.getUsers();
        List <UserEventsResponse>  res = new ArrayList<>();
        for (User user :users){
            UserEventsResponse userEventsResponse = new UserEventsResponse();
            userEventsResponse.setUserId(user.getUserId());
            userEventsResponse.setEventId(eventId);
            userEventsResponse.setEventName(event.getEventName());
            userEventsResponse.setUsername(user.getUsername());
            userEventsResponse.setFirstName(user.getFirstName());
            userEventsResponse.setLastName(user.getLastName());
            res.add(userEventsResponse);
        }
        return res ;

    }
}
