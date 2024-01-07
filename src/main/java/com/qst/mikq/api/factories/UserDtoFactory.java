package com.qst.mikq.api.factories;

import com.qst.mikq.api.dto.UserDto;
import com.qst.mikq.storage.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDtoFactory {

    public UserDto makeUserDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .login(userEntity.getLogin())
                .password(userEntity.getPassword())
                .level(userEntity.getLevel())
                .experience(userEntity.getExperience())
                .build();

    }
}
