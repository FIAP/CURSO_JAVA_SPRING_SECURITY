package com.springsecutiry.fiap.modules.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecutiry.fiap.modules.user.entity.User;
import com.springsecutiry.fiap.modules.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService createUserService;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return createUserService.execute(user);
    }

}