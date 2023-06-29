package com.eventHive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventHive.models.entities.Event;
import com.eventHive.models.entities.Location;
import com.eventHive.services.EventService;
import com.eventHive.services.LocationService;

/**
 * @author vmikolyuk
 * @since 23.06.2023
 */
@RestController
@RequestMapping("/locations")
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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
