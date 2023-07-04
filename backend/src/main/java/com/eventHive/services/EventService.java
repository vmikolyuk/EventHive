package com.eventHive.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventHive.entities.Event;
import com.eventHive.repositories.EventRepository;

/**
 * @author vmikolyuk
 * @since 29.06.2023
 */
@Service
public class EventService
{
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository)
    {
        this.eventRepository = eventRepository;
    }

    public Event getById(Long eventId)
    {
        return eventRepository.findById(eventId).orElse(null);
    }

    public List<Event> getByLocationId(Long locationId)
    {
        return eventRepository.findAllByLocationId(locationId);
    }

    public List<Event> getActive()
    {
        return eventRepository.findActiveEvents(new Date());
    }

    public Long create(Event event)
    {
        return eventRepository.save(event).getId();
    }
}
