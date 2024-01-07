package com.qst.mikq.api.controllers;

import com.qst.mikq.api.dto.UserDto;
import com.qst.mikq.api.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {

    UserService userService;
    private static final String CREATE_USER = "/api/teams/users";

    @PostMapping
    public UserDto createUser(
           @RequestParam(defaultValue = "user") String name,
           @RequestParam String login,
           @RequestParam String password
    ) {

        return null;
    }



}


