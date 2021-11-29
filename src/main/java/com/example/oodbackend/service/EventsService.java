package com.example.oodbackend.service;


import com.example.oodbackend.dto.EventsRequest;
import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.entity.Events;
import com.example.oodbackend.entity.Location;
import com.example.oodbackend.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventsService {
    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private LocationService locationService;

    @Autowired
    private CategoriesService categoriesService;

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
}
