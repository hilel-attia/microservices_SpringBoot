package com.ms.eventservice.services;
import com.ms.eventservice.repository.EventRespository;
import org.springframework.stereotype.Service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.eventservice.entities.Event;
import java.util.List;
@Service
public class EventService implements IEventService{

    @Autowired
    EventRespository eventRepoistory;

    public Event ajouterEvent(Event event){
        eventRepoistory.save(event);
        return event;
    }

    public List<Event> getAllEvents(){
        List<Event> arrayEvent =  eventRepoistory.findAll();
        return arrayEvent;
    }
    public void deleteEventById(int eventId){
        Event event = eventRepoistory.findById(eventId).get();
        eventRepoistory.delete(event);

    }
    public Event getEventById(int eventId){
         Event event = eventRepoistory.findById(eventId).get();
        return event;
    }
}
