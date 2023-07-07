package com.eventHive.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.eventHive.entities.File;

/**
 * @author vmikolyuk
 * @since 08.07.2023
 */
@Component
public class FileStorageService
{
    @Value("${base.fileDir}")
    private String fileDir;

    public java.io.File getFromDisk(File file)
    {
        Path path = Path.of(fileDir + "/" + file.getId() + "/" + file.getName());
        return path.toFile();
    }

    public void saveToDist(File file, InputStream is)
    {
        Path pathDir = Path.of(fileDir + "/" + file.getId());
        new java.io.File(pathDir.toUri()).mkdirs();
        Path targetPath = Path.of(fileDir + "/" + file.getId() + "/" + file.getName());
        try
        {
            Files.copy(is, targetPath, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
