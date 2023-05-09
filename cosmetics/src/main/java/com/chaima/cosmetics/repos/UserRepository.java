package com.chaima.cosmetics.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaima.cosmetics.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername (String username);
}