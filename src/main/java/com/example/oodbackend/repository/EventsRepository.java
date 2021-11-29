package com.example.oodbackend.repository;

import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.entity.Events;
import com.example.oodbackend.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import  java.util.*;

@Repository
public interface EventsRepository extends JpaRepository<Events,Long> {



    @Query(
            value = "SELECT * FROM events  where category_id = ?1 AND location_id = ?2",
            nativeQuery = true
    )
    public List<Events> findByCategoryIdAndLocationIdIn(Long CategoryId , Long LocationId);
}
