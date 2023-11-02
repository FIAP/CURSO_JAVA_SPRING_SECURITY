package com.springsecutiry.fiap.modules.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecutiry.fiap.modules.user.entity.User;
import com.springsecutiry.fiap.modules.user.request.UserRoleRequest;
import com.springsecutiry.fiap.modules.user.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
   UserService _userService;


  @PostMapping("/create")
  public User create(@RequestBody User user) {
    return _userService.create(user);
  }

  @PostMapping("/role")
  public User createRole(@RequestBody UserRoleRequest userRolesRequest) {
    return _userService.createRole(userRolesRequest);
  }

}
