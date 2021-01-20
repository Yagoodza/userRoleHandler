package com.yagudza.servise;

import com.yagudza.dto.UserResponseDto;
import com.yagudza.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Iterable<UserDto> findAll();
    UserDto findById(String login);
    void deleteById(String login);
    UserResponseDto createNewUser(UserDto userDto);
    UserResponseDto updateNewUser(UserDto userDto);
}
