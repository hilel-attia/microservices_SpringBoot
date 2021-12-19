package com.ms.eventservice.services;

import com.ms.eventservice.entities.Event;

import java.util.List;

public interface IEventService {

    public Event ajouterEvent(Event event);
    List<Event> getAllEvents();
    public void deleteEventById(int eventId);
    public Event getEventById(int eventId);
}
