package com.eventHive.controllers;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eventHive.entities.File;
import com.eventHive.services.FileService;
import com.eventHive.services.FileStorageService;

/**
 * @author vmikolyuk
 * @since 07.07.2023
 */
@RestController
@RequestMapping("/rest/files")
public class FileControllerImpl implements FileController
{
    private final FileService fileService;
    private final FileStorageService storageService;

    @Autowired
    public FileControllerImpl(FileService fileService, FileStorageService storageService)
    {
        this.fileService = fileService;
        this.storageService = storageService;
    }

    @Override
    @GetMapping(value = "/{id}", produces = { MediaType.IMAGE_JPEG_VALUE })
    public ResponseEntity<java.io.File> getById(@PathVariable Long id)
    {
        File file = fileService.getById(id);
        if (file == null)
        {
            throw new ResourceNotFoundException(String.format("Файл с идентификатором '%s' не найден", id));
        }
        return ResponseEntity.ok(storageService.getFromDisk(file));
    }

    @Override
    @PostMapping(value = "/upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Long> upload(@RequestParam("file") MultipartFile file)
    {
        String fileName = file.getOriginalFilename();
        File fileEntity = fileService.create(fileName);
        try (InputStream is = file.getInputStream())
        {
            storageService.saveToDist(fileEntity, is);
        }
        catch (java.lang.Exception e)
        {
            throw new RuntimeException(e);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(fileEntity.getId());
    }
}
