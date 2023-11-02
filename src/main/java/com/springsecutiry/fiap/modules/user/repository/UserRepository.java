package com.springsecutiry.fiap.modules.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springsecutiry.fiap.modules.user.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
  User findByUsername(String username);
}
