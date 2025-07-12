package com.codewithudo.eventmanagementapi.service;

import com.codewithudo.eventmanagementapi.model.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private final List<Event> events = new ArrayList<>();
    private int nextId = 1;

    // Add a new event
    public boolean addEvent(Event event) {
        event.setId(nextId++);
        events.add(event);
        return true;
    }

    // Get all events
    public List<Event> getAllEvents() {
        return events;
    }

    // Get event by ID
    public Event getEventById(int id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return event;
            }
        }
        return null;
    }

    // Update an existing event
    public boolean updateEvent(int id, Event updatedEvent) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                event.setName(updatedEvent.getName());
                event.setLocation(updatedEvent.getLocation());
                event.setDate(updatedEvent.getDate());
                event.setTime(updatedEvent.getTime());
                event.setDescription(updatedEvent.getDescription());
                return true;
            }
        }
        return false;
    }

    // Delete an event by ID
    public boolean deleteEvent(int id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                events.remove(event);
                return true;
            }
        }
        return false;
    }
}
