package com.example.oodbackend.entity;


import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;


    @NotBlank(message = "Please Add Location name ")
    @Length(max =100 ,min =1)
    private String locationName ;

    public Location() {

    }




    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", locationName='" + locationName + '\'' +
                '}';
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Location(Long locationId, String locationName) {
        this.locationId = locationId;
        this.locationName = locationName;
    }
}
