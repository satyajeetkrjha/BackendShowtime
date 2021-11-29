package com.example.oodbackend.repository;

import com.example.oodbackend.entity.Categories;
import com.example.oodbackend.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Events,Long> {

}
