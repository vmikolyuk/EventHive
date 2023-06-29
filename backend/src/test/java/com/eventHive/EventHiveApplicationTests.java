package com.eventHive;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eventHive.models.entities.Event;
import com.eventHive.models.entities.Location;
import com.eventHive.repositories.EventRepository;
import com.eventHive.repositories.LocationRepository;

@SpringBootTest
class EventHiveApplicationTests
{
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private EventRepository eventRepository;

    @Test
    void createLocations()
    {
        createLocation();
    }

    @Test
    void createEvents()
    {
        createEvent();
    }

    private Location createLocation()
    {
        Location location = new Location();
        location.setTitle(RandomStringUtils.randomAlphabetic(10));
        location.setAddress(RandomStringUtils.randomAlphabetic(200));
        location.setLatitude(RandomUtils.nextFloat());
        location.setLongitude(RandomUtils.nextFloat());
        locationRepository.save(location);
        return location;
    }

    private Event createEvent()
    {
        int memberCount = RandomUtils.nextInt();
        Event event = new Event();
        event.setCreationDate(new Date());
        event.setLocation(createLocation());
        event.setStartDate(new Date());
        event.setDuration(RandomUtils.nextLong());
        event.setCountMembers(memberCount);
        event.setTotalMembers(memberCount + RandomUtils.nextInt());
        eventRepository.save(event);
        return event;
    }
}