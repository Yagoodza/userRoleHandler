package com.yagudza.servise;

import com.yagudza.domain.User;
import com.yagudza.dto.UserDto;
import com.yagudza.dto.UsersDto;
import com.yagudza.exceptions.UserNotFoundException;
import com.yagudza.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Iterable<UsersDto> findAll() {
        Iterable<User> usersIterable = userRepository.findAll();
        return StreamSupport.stream(usersIterable.spliterator(), false)
                .map(user -> modelMapper.map(user, UsersDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(String login) {
        Object user = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void deleteById(String login) {
        if (!userRepository.existsById(login)) {
            throw new UserNotFoundException();
        }
        userRepository.deleteById(login);
    }
}
