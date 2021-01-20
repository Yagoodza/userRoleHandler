package com.yagudza.mappers;

import com.yagudza.domain.User;
import com.yagudza.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "roles", ignore = true)
    UserDto toDto (User user);

    Iterable<UserDto> toDto (Iterable<User> users);

    User toUser (UserDto userDto);
}
