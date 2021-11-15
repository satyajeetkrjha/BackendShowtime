package com.example.oodbackend.entity;


import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Location {


    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;


    @NotBlank(message = "Please Add Department name ")
    @Length(max =100 ,min =1)
    private String locationName ;




    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }


    public Location(){

    }
    @Override
    public String toString() {
        return "Location{" +
                "Id=" + locationId +
                ", locationName='" + locationName + '\'' +
                '}';
    }

}
