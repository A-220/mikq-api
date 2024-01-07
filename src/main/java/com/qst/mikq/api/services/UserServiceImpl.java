package com.qst.mikq.api.services;

import com.qst.mikq.api.dto.UserDto;
import com.qst.mikq.storage.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Override
    public UserDto createUser(String name, String login) {
        userRepository.findByLogin(login).ifPresent(user -> {
                    throw new RuntimeException();
                });
        return null;
    }
}
