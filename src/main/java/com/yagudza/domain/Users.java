package com.yagudza.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {
    @Column(nullable = false)
    private String name;
    @Id
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_login", "role_id"})},
            joinColumns = {@JoinColumn(name = "user_login", referencedColumnName = "login")}
            , inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")
    })
    private List<Roles> roles;

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }


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
}
