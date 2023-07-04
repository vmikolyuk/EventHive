package com.eventHive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventHive.entities.Event;
import com.eventHive.entities.Location;
import com.eventHive.services.EventService;
import com.eventHive.services.LocationService;

/**
 * @author vmikolyuk
 * @since 23.06.2023
 */
@RestController
@RequestMapping("/rest/locations")
public class LocationControllerImpl implements LocationController
{
    private final LocationService locationService;
    private final EventService eventService;

    @Autowired
    public LocationControllerImpl(LocationService locationService, EventService eventService)
    {
        this.locationService = locationService;
        this.eventService = eventService;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Location>> getAll()
    {
        return ResponseEntity.ok(locationService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Location> getById(@PathVariable final Long id)
    {
        Location location = locationService.getById(id);
        if (location == null)
        {
            throw new ResourceNotFoundException(String.format("Локация с идентификатором '%s' не найдена", id));
        }
        return ResponseEntity.ok(location);
    }

    @Override
    @GetMapping("/{id}/events")
    public ResponseEntity<List<Event>> getEvents(@PathVariable final Long id)
    {
        return ResponseEntity.ok(eventService.getByLocationId(id));
    }
}
