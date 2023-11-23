package com.example.ensf614api.controllers;

import com.example.ensf614api.models.User;
import com.example.ensf614api.stores.UserStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/User")
public class UserController {

	private final UserStore userStore;
	
	@Autowired
	public UserController(UserStore userStore) {
		this.userStore = userStore;
	}
	
	@GetMapping("getUsers")
	public Iterable<User> getAllUsers(){
		return userStore.getUsers();
	}
}
