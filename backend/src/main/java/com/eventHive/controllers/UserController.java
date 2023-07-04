package com.eventHive.controllers;

import org.springframework.http.ResponseEntity;

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
 * @since 04.07.2023
 */
@Tag(name = "User", description = "Работа с пользователями")
public interface UserController
{
    /**
     * Получить пользователя по его идентификатору
     *
     * @param id идентификатор пользователя
     * @return пользователь
     */
    @Operation(summary = "Получить пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден",
                    content = @Content(schema = @Schema(implementation = Exception.class))),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    ResponseEntity<User> getById(@Parameter(description = "Идентификатор пользователя") Long id);
}
