package com.eventHive.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventHive.entities.Location;
import com.eventHive.repositories.LocationRepository;

/**
 * @author vmikolyuk
 * @since 27.06.2023
 */
@Service
public class LocationService
{
    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository)
    {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAll()
    {
        return StreamSupport.stream(locationRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Location getById(Long locationId)
    {
        return locationRepository.findById(locationId).orElse(null);
    }
}
