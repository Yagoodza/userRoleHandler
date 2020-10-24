package com.yagudza.repository;

import com.yagudza.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, String> {

    @Query(nativeQuery = true, value = "select u.login, u.name, u.password from User u ")
    Iterable<User> findAll();

    @Query(nativeQuery = true, value = "select u.login, u.name, u.password  from User u where u.login = ?1")
    Optional<User> findById(String var);

}
