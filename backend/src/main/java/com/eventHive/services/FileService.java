package com.eventHive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventHive.entities.File;
import com.eventHive.repositories.FileRepository;

/**
 * @author vmikolyuk
 * @since 07.07.2023
 */
@Service
public class FileService
{

    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository)
    {
        this.fileRepository = fileRepository;
    }

    public File create(String fileName)
    {
        File file = new File();
        file.setName(fileName);
        return fileRepository.save(file);
    }

    public File getById(Long id)
    {
        return fileRepository.findById(id).orElse(null);
    }
}
