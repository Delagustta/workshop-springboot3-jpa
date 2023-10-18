package com.udemy.course.controllers;

import com.udemy.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Maria", "maria@maria.com", "999999", "123456");
        return ResponseEntity.ok().body(user);
    }
}
