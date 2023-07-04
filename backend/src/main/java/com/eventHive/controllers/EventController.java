package com.eventHive.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.eventHive.entities.Event;
import com.eventHive.entities.User;

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
@Tag(name = "Event", description = "Работа с событиями")
public interface EventController
{
    /**
     * Получить список активных событий
     *
     * @return список активных событий
     */
    @Operation(summary = "Получить список активных событий")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    ResponseEntity<List<Event>> getActive();

    /**
     * Получить событие по его идентификатору
     *
     * @param id идентификатор события
     * @return событие
     */
    @Operation(summary = "Получить событие")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "404", description = "Событие не найдено",
                    content = @Content(schema = @Schema(implementation = Exception.class))),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    ResponseEntity<Event> getById(@Parameter(description = "Идентификатор события") Long id);

    /**
     * Получить список участников события
     *
     * @param id идентификатор события
     * @return список участников события
     */
    @Operation(summary = "Получить список участников события")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    ResponseEntity<List<User>> getUsers(@Parameter(description = "Идентификатор события") Long id);

    /**
     * Создать событие
     * @param event событие
     * @return идентификатор события
     */
    @Operation(summary = "Создать событие")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Успешно создано"),
            @ApiResponse(responseCode = "404", description = "Локация не найдена",
                    content = @Content(schema = @Schema(implementation = Exception.class))),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    ResponseEntity<Long> create(@Parameter(description = "Событие") Event event);
}
