package com.ms.eventservice.controller;
import java.util.Date;
import java.util.List;


import com.ms.eventservice.entities.Event;
import com.ms.eventservice.services.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event")
@RefreshScope
public class EvenetRestApiController {
    @Autowired
    IEventService ieventservice;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        if (event.getImage() == null || event.getName() == null || event.getDescription() == null) {
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }
        Event e = ieventservice.ajouterEvent(event);
        return new ResponseEntity<Event>(e, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getEvent(){
        List<Event> arrayEvent = ieventservice.getAllEvents();
        return new ResponseEntity<List<Event>>(arrayEvent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") int id){
            ieventservice.deleteEventById(id);
            String responseContent = "event has been deleted successfully";
            return new ResponseEntity<String>(responseContent,HttpStatus.OK);
    }
}
