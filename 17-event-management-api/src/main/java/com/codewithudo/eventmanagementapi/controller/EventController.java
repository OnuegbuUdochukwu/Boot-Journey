package com.codewithudo.eventmanagementapi.controller;

import com.codewithudo.eventmanagementapi.model.Event;
import com.codewithudo.eventmanagementapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // Create a new event
    @PostMapping
    public ResponseEntity<String> createEvent(@RequestBody Event event) {
        boolean added = eventService.addEvent(event);
        if (added) {
            return new ResponseEntity<>("Event successfully created.", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Event could not be created.", HttpStatus.BAD_REQUEST);
    }

    // Get all events
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    // Get event by ID
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable int id) {
        Event event = eventService.getEventById(id);
        if (event != null) {
            return new ResponseEntity<>(event, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update event
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEvent(@PathVariable int id, @RequestBody Event updatedEvent) {
        boolean updated = eventService.updateEvent(id, updatedEvent);
        if (updated) {
            return new ResponseEntity<>("Event updated successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Event not found.", HttpStatus.NOT_FOUND);
    }

    // Delete event
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable int id) {
        boolean deleted = eventService.deleteEvent(id);
        if (deleted) {
            return new ResponseEntity<>("Event deleted successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Event not found.", HttpStatus.NOT_FOUND);
    }
}
