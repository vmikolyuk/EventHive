package com.eventHive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventHive.entities.Event;
import com.eventHive.entities.Location;
import com.eventHive.entities.User;
import com.eventHive.services.EventService;
import com.eventHive.services.LocationService;
import com.eventHive.services.UserService;

/**
 * @author vmikolyuk
 * @since 23.06.2023
 */
@RestController
@RequestMapping("/rest/events")
public class EventControllerImpl implements EventController
{
    private final EventService eventService;
    private final LocationService locationService;
    private final UserService userService;

    @Autowired
    public EventControllerImpl(EventService eventService, LocationService locationService, UserService userService)
    {
        this.eventService = eventService;
        this.locationService = locationService;
        this.userService = userService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable final Long id)
    {
        Event event = eventService.getById(id);
        if (event == null)
        {
            throw new ResourceNotFoundException(String.format("Событие с идентификатором '%s' не найдено", id));
        }
        return ResponseEntity.ok(eventService.getById(id));
    }

    @Override
    @GetMapping("/active")
    public ResponseEntity<List<Event>> getActive()
    {
        return ResponseEntity.ok(eventService.getActive());
    }

    @Override
    @GetMapping("/{id}/users")
    public ResponseEntity<List<User>> getUsers(@PathVariable final Long id)
    {
        return ResponseEntity.ok(userService.getByEventId(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<Long> create(@RequestBody Event event)
    {
        Location location = event.getLocation();

        if (location == null || locationService.getById(location.getId()) == null)
        {
            throw new ResourceNotFoundException("Локация не найдена");
        }

        Long eventId = eventService.create(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventId);
    }

}
