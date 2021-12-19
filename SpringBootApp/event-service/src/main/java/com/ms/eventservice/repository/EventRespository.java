package com.ms.eventservice.repository;
import com.ms.eventservice.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EventRespository extends JpaRepository<Event, Integer> {

}
