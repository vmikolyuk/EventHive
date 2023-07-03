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
import com.eventHive.models.entities.User;
import com.eventHive.services.EventService;
import com.eventHive.services.UserService;

/**
 * @author vmikolyuk
 * @since 23.06.2023
 */
@RestController
@RequestMapping("/events")
public class EventControllerImpl implements EventController
{
    private final EventService eventService;
    private final UserService userService;

    @Autowired
    public EventControllerImpl(EventService eventService, UserService userService)
    {
        this.eventService = eventService;
        this.userService = userService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable final Long id)
    {
        Event event = eventService.getById(id);
        if (event == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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
}
