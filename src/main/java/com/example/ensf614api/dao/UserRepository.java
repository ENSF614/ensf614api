package com.example.ensf614api.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.example.ensf614api.models.User;
import org.springframework.data.repository.query.Param;

@Service
public interface UserRepository extends CrudRepository<User, Integer>{

    @Query("select u from User u where u.userID=:userId")
    public User getUser(@Param("userId") String userId);

    @Query("select u from User u where u.email=:email and u.password=:password")
    public User signIn(@Param("email") String email, @Param("password") String password);

    @Query("select u from User u where u.email=:email")
    public User doesUserExist(@Param("email") String email);
}
