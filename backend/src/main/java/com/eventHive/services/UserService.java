package com.eventHive.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventHive.entities.User;
import com.eventHive.repositories.UserRepository;

/**
 * @author vmikolyuk
 * @since 29.06.2023
 */
@Service
public class UserService
{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<User> getByEventId(Long eventId)
    {
        return userRepository.findByEventId(eventId);
    }

    public User getById(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }
}
