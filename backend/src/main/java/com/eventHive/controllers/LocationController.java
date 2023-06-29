package com.eventHive.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.eventHive.models.entities.Event;
import com.eventHive.models.entities.Location;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author vmikolyuk
 * @since 28.06.2023
 */
@Tag(name = "Location", description = "Работа с локациями")
public interface LocationController
{
    /**
     * Получить все локации
     * @return список существующих локаций
     */
    @Operation(summary = "Получить список всех локаций")
    ResponseEntity<List<Location>> getAll();

    /**
     * Получить локацию по ее идентификатору
     * @param id идентификатор локации
     * @return локация
     */
    @Operation(summary = "Получение локации")
    ResponseEntity<Location> getById(
            @Parameter(description = "Идентификатор локации") Long id);

    ResponseEntity<List<Event>> getEvents(Long id);
}
