package com.eventHive;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eventHive.entities.Event;
import com.eventHive.entities.EventUser;
import com.eventHive.entities.Location;
import com.eventHive.entities.User;
import com.eventHive.repositories.EventRepository;
import com.eventHive.repositories.EventUserRepository;
import com.eventHive.repositories.LocationRepository;
import com.eventHive.repositories.UserRepository;

@SpringBootTest
class EventHiveApplicationTests
{
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventUserRepository eventUserRepository;

    @Test
    void created()
    {
        createLocation();
        createEvent();
        createUser();
        createEventUser();
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

    private User createUser()
    {
        User user = new User();
        user.setFullName(RandomStringUtils.randomAlphabetic(10));
        user.setPhoneNumber(RandomStringUtils.randomNumeric(11));
        user.setAvatarPath(RandomStringUtils.randomAlphabetic(100));
        userRepository.save(user);
        return user;
    }

    private EventUser createEventUser()
    {
        EventUser eventUser = new EventUser();
        eventUser.setEvent(createEvent());
        eventUser.setUser(createUser());
        eventUser.setMemberCount(RandomUtils.nextInt());
        eventUserRepository.save(eventUser);
        return eventUser;
    }
}