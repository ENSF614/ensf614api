package com.example.ensf614api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ensf614api.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{}
