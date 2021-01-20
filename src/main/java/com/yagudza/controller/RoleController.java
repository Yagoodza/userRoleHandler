package com.yagudza.controller;

import com.yagudza.domain.Role;
import com.yagudza.dto.UserDto;
import com.yagudza.servise.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/showRoles")
    public ResponseEntity<Iterable<Role>> showUsers() {
        return ResponseEntity.ok(roleService.findAll());
    }
}
