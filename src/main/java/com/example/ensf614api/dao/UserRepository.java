package com.example.ensf614api.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.ensf614api.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{}
