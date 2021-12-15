package com.example.oodbackend.service;


import com.example.oodbackend.dto.EventLocationResponse;
import com.example.oodbackend.dto.EventsRequest;
import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.entity.Events;
import com.example.oodbackend.entity.Location;
import com.example.oodbackend.repository.CategoriesRepository;
import com.example.oodbackend.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventsService {
    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private LocationService locationService;

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private CategoriesRepository categoriesRepository;

    public void saveEvents(EventsRequest eventsRequest) {
         Location location  = locationService.fetchLocationById(eventsRequest.getLocationId());
         Categories categories =  categoriesService.fetchCategoryById(eventsRequest.getCategoryId());
         Events events = new Events();
         events.setCategories(categories);
         events.setEventDescription(eventsRequest.getEventDescription());
         events.setEventName(eventsRequest.getEventName());
         events.setEventStartDate(eventsRequest.getStartDate());
         events.setEventEndDate(eventsRequest.getEndDate());
         events.setLocation(location);
         eventsRepository.save(events);

    }

    public List<EventLocationResponse> getEventsByLocationCategory(Long categoryId, Long locationId) {
        List <Location> locations = locationService.fetchAllLocations();
        List <Categories> categories = categoriesRepository.findAll();

        List<Events> events = eventsRepository.findByCategoryIdAndLocationIdIn(categoryId,locationId);

        System.out.println(events);

        List <EventLocationResponse> result = new ArrayList<>();
        for (Events item :events) {
            EventLocationResponse eventLocationResponse = new EventLocationResponse();
            Long locatioIdTaken = item.getLocation().getLocationId();
            eventLocationResponse.setEventName(item.getEventName());
            eventLocationResponse.setEventDescription(item.getEventDescription());
            eventLocationResponse.setEndDate(item.getEventEndDate());
            eventLocationResponse.setStartDate(item.getEventStartDate());
            eventLocationResponse.setEventId(item.getEventId());
            result.add(eventLocationResponse);

        }
        return result;
    }
}
