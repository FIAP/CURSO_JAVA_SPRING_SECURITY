package com.springsecutiry.fiap.modules.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecutiry.fiap.modules.user.entity.Role;
import com.springsecutiry.fiap.modules.user.entity.User;
import com.springsecutiry.fiap.modules.user.repository.UserRepository;
import com.springsecutiry.fiap.modules.user.request.UserRoleRequest;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User create(User user) {

        User existsUser = userRepository.findByUsername(user.getUsername());

        if (existsUser != null) {
            throw new Error("Usuário já cadastrado!");
        }

        user.setPassword(passwordEncoder().encode(user.getPassword()));

        User createdUser = userRepository.save(user);

        return createdUser;
    }

    public User createRole(UserRoleRequest userRolesRequest) {
        Optional<User> userExists = userRepository.findById(userRolesRequest.getUserId());

        if (userExists.isEmpty()) {
            throw new Error("Usuário não encontrado!");
        }

        List<Role> roles = new ArrayList<>();

        roles = userRolesRequest.getListRoles().stream().map(role -> {
            return new Role(role);
        }).collect(Collectors.toList());

        User user = userExists.get();

        user.setRoles(roles);

        userRepository.save(user);

        return user;
    }
}
