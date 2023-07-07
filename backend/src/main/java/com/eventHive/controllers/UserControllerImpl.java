package com.eventHive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventHive.entities.User;
import com.eventHive.services.UserService;

/**
 * @author vmikolyuk
 * @since 04.07.2023
 */
@RestController
@RequestMapping("/rest/users")
public class UserControllerImpl implements UserController
{
    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService)
    {
        this.userService = userService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable final Long id)
    {
        User user = userService.getById(id);
        if (user == null)
        {
            throw new ResourceNotFoundException(String.format("Пользователь с идентификатором '%s' не найден", id));
        }
        return ResponseEntity.ok(user);
    }
}
