package com.springsecutiry.fiap.modules.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springsecutiry.fiap.modules.user.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);

    @Query("SELECT u from User u JOIN FETCH u.roles where username = :username ")
    User findByUsernameFetchRoles(@Param("username") String username);
}
