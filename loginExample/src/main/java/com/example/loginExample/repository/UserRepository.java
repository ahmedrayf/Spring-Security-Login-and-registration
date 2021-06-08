package com.example.loginExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loginExample.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
