package com.yagudza.servise;

import com.yagudza.dto.UserDto;
import com.yagudza.dto.UsersDto;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.LinkedList;

@Service
public interface UserService {

    Iterable<UsersDto> findAll();
    UserDto findById(String login);
    void deleteById(String login);
}
