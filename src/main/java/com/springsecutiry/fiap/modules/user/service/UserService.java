package com.springsecutiry.fiap.modules.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecutiry.fiap.modules.user.entity.User;
import com.springsecutiry.fiap.modules.user.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public User execute(User user) {

    var validateUser = userRepository.findByUsername(user.getUsername());

    if (validateUser != null) {
      throw new Error("Usuário já cadastrado!");
    }

    var createdUser = userRepository.save(user);

    return createdUser;
  }

}
