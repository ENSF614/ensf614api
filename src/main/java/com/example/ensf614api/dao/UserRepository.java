package com.example.ensf614api.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.ensf614api.models.User;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer>{

    @Query("select u from User u where u.userID=:userId")
    public User getUser(@Param("userId") String userId);
}
