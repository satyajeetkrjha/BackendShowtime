package com.example.oodbackend.service;


import com.example.oodbackend.dto.EventsFollowedByAUser;
import com.example.oodbackend.dto.TrendingEvents;
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

    public List<EventsFollowedByAUser> getEventsForUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        Set <Events> events = user.getEvents();
        List <EventsFollowedByAUser> res = new ArrayList<>();
        for(Events event: events){
            EventsFollowedByAUser eventsFollowedByAUser = new EventsFollowedByAUser();
            eventsFollowedByAUser.setEventId(event.getEventId());
            eventsFollowedByAUser.setEventName(event.getEventName());
            eventsFollowedByAUser.setEventDescription(event.getEventName());
            res.add(eventsFollowedByAUser);

        }
        return res ;

    }

    public List<TrendingEvents> getTrendingEvents() {
        List<Events> events  = eventsRepository.findAll();
        List <TrendingEvents> res = new ArrayList<>();

        for( Events e: events){

            int totalUsers = e.getUsers().size();
            if(totalUsers >2){
                TrendingEvents trendingEvents = new TrendingEvents();
                trendingEvents.setTotalUsers(totalUsers);
                trendingEvents.setEndDate(e.getEventEndDate());
                trendingEvents.setEventName(e.getEventName());
                trendingEvents.setEventId(e.getEventId());
                trendingEvents.setStartDate(e.getEventStartDate());
                res.add(trendingEvents);

            }
        }
        return res ;

    }
}
