package com.eventHive.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.eventHive.models.entities.Event;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author vmikolyuk
 * @since 28.06.2023
 */
@Tag(name = "Event", description = "Работа с мероприятиями")
public interface EventController
{

    ResponseEntity<Event> getById(Long id);

    ResponseEntity<List<Event>> getActive();
}
