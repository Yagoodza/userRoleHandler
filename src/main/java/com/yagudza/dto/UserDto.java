package com.yagudza.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yagudza.domain.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class UserDto {

    private String name;
    private String login;
    private String password;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles == null ? new HashSet<>() : roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
