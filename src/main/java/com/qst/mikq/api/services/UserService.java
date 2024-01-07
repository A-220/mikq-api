package com.qst.mikq.api.services;

import com.qst.mikq.api.dto.UserDto;

public interface UserService {
    UserDto createUser(String name, String login);
}
