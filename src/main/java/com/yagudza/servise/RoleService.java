package com.yagudza.servise;

import com.yagudza.domain.Role;
import com.yagudza.dto.RoleDto;
import com.yagudza.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Iterable<Role> findAll();
}
