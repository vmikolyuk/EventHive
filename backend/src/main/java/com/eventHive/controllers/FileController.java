package com.eventHive.controllers;

import java.io.File;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author vmikolyuk
 * @since 07.07.2023
 */
@Tag(name = "File", description = "Работа с файлами")
public interface FileController
{
    /**
     * Получить файл по его идентификатору
     *
     * @param id идентификатор файла
     * @return файл
     */
    @Operation(summary = "Получить файл")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно"),
            @ApiResponse(responseCode = "404", description = "Файл не найден",
                    content = @Content(schema = @Schema(implementation = Exception.class))),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    ResponseEntity<File> getById(@Parameter(description = "Идентификатор файла") Long id);

    /**
     * Загрузить файл
     *
     * @return идентификатор файла
     */
    @Operation(summary = "Загрузить файл")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Успешно создан"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
    })
    ResponseEntity<Long> upload(@Parameter(description = "Файл") MultipartFile file);
}
