package com.qst.mikq.api.controllers;
//
//import com.qst.mikq.api.dto.UserDto;
//import com.qst.mikq.api.services.UserService;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@RequiredArgsConstructor
//public class UserController {
//
//    UserService userService;
//    private static final String CREATE_USER = "/api/teams/users";
//
//    @PostMapping
//    public UserDto createUser(
//           @RequestParam(defaultValue = "user") String name,
//           @RequestParam String login,
//           @RequestParam String password
//    ) {
//
//        return null;
//    }
//
//}

// TODO: TEST is delete, PATH http://localhost:8080/swagger-ui/index.html
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/custom", method = RequestMethod.POST)
    public String custom() {
        return "custom";
    }
}

