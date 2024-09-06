package com.project.userservice.controller;

import com.project.userservice.model.Response;
import com.project.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Response getByUserId(@RequestParam("userId") Integer userId) {
        return userService.getUserByUserId(userId);
    }
}