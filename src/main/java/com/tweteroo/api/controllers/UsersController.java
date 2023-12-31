package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.models.Users;
import com.tweteroo.api.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth/sign-up")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getUsers() {
        return userService.findAllUsers();
    }

    @PostMapping
    public String createUser(@RequestBody @Valid UserDTO req) {
        return userService.createUser(req);
    }

}
