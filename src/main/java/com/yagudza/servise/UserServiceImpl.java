package com.yagudza.servise;

import com.yagudza.domain.User;
import com.yagudza.dto.UserResponseDto;
import com.yagudza.dto.UserDto;
import com.yagudza.exceptions.UserNotFoundException;
import com.yagudza.mappers.UserMapper;
import com.yagudza.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<UserDto> findAll() {
        Iterable<User> users = userRepository.findAll();
        return UserMapper.INSTANCE.toDto(users);
    }

    @Override
    public UserDto findById(String login) {
        User user = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
        return UserMapper.INSTANCE.toDto(user);
    }

    @Override
    public void deleteById(String login) {
        if (!userRepository.existsById(login)) {
            return;
        }
        userRepository.deleteById(login);
    }

    public UserResponseDto createNewUser(UserDto userDto) {

        UserResponseDto response = new UserResponseDto();

        if (userRepository.existsById(userDto.getLogin())) {
            response.setError("User has been already created");
        } else if (userDto.getLogin() == null || userDto.getLogin().trim().equals("")) {
            response.setError("Login is empty");
        }
        if (userDto.getName() == null || userDto.getName().trim().equals("")) {
            response.setError("Name is empty");
        }
        if (userDto.getLogin() == null || userDto.getLogin().trim().equals("")) {
            response.setError("Login is empty");
        } else {
            if (!userDto.getPassword().matches("((?=.*[1-9])(?=.*[A-Z])).+")) {
                response.setError("Password must have symbol in upper case and digit");
            }
            if (!userDto.getPassword().matches(".{6,20}"))
                response.setError("Password must contain more then 6 and less then 20 symbols");
        }
        if (userDto.getRoles() == null || userDto.getRoles().isEmpty()) {
            response.setError("User must have one or more roles");
        }

        if (!response.getErrors().isEmpty()) {
            response.setSuccess(false);
        } else {
            response.setSuccess(true);
            User user = UserMapper.INSTANCE.toUser(userDto);
            userRepository.save(user);
        }
        return response;
    }

    public UserResponseDto updateNewUser(UserDto userDto) {
        return new UserResponseDto();// stub
    }

    private UserResponseDto check(UserDto userDto, UserResponseDto response) {
        return new UserResponseDto();// stub
    }
}
