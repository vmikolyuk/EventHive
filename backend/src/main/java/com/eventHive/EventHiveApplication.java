package com.eventHive;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventHiveApplication
{
    private final static String APP_PROP_NAME = "application.properties";
    private final static String FILE_DIR_PROP_NAME = "base.fileDir";

    public static void main(String[] args)
    {
        SpringApplication.run(EventHiveApplication.class, args);
        initializeFileDir();
    }

    private static void initializeFileDir()
    {
        Properties appProps = new Properties();
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(APP_PROP_NAME))
        {
            appProps.load(is);
            String fileFir = appProps.getProperty(FILE_DIR_PROP_NAME);
            boolean fileDirCreated = new File(fileFir).mkdirs();
            if (fileDirCreated)
            {
                System.out.printf("Директория '%s' для хранения файлов создана%n", fileFir);
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}