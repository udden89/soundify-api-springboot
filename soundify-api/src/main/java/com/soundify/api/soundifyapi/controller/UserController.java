package com.soundify.api.soundifyapi.controller;


import com.soundify.api.soundifyapi.model.User;
import com.soundify.api.soundifyapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/user/add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping("/api/user/register")
    public Optional<User> registerUser(@RequestBody User user) {
        System.out.println(user);
        return userService.addUser(user);
    }

    @GetMapping("/api/user")
    public List<User> getAllUsers() {
       return  userService.getAllUsers();
    }
}
