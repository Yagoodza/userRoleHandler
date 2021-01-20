package com.yagudza.controller;

import com.yagudza.dto.UserResponseDto;
import com.yagudza.dto.UserDto;
import com.yagudza.servise.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/showUsers")
    public ResponseEntity<Iterable<UserDto>> showUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/show/{login}")
    public ResponseEntity<UserDto> showUserByLogin(@PathVariable("login") String login) {
        return ResponseEntity.ok(userService.findById(login));
    }

    @DeleteMapping("/delete/{login}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserByLogin(@PathVariable("login") String login) {
        userService.deleteById(login);
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserResponseDto> addUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.createNewUser(userDto));
    }
}
