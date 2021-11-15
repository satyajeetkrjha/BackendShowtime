package com.example.oodbackend.entity;


import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;


    @NotBlank(message = "Please Add Event name ")
    @Length(max =100 ,min =2)
    private String eventName ;



    private String eventDescription;

    //many fields
    // are yet to be added
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
