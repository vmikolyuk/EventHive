package com.eventHive.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.eventHive.entities.Event;
import com.eventHive.entities.Location;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
     *
     * @return список существующих локаций
     */
    @Operation(summary = "Получить список всех локаций")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    ResponseEntity<List<Location>> getAll();

    /**
     * Получить локацию по ее идентификатору
     *
     * @param id идентификатор локации
     * @return локация
     */
    @Operation(summary = "Получить локацию")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "404", description = "Локация не найдена",
                    content = @Content(schema = @Schema(implementation = Exception.class))),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    ResponseEntity<Location> getById(@Parameter(description = "Идентификатор локации") Long id);

    /**
     * Получить события локации
     *
     * @param id идентификатор локации
     * @return список событий локации
     */
    @Operation(summary = "Получить список всех событий локации")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    ResponseEntity<List<Event>> getEvents(@Parameter(description = "Идентификатор локации") Long id);
}
