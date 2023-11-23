package com.example.ensf614api.stores;

import org.springframework.stereotype.Service;

import com.example.ensf614api.dao.UserRepository;
import com.example.ensf614api.models.User;

@Service
public class UserStore {
	
	private UserRepository userRepo;
	
	public UserStore(UserRepository userRepository) {
		this.userRepo = userRepository;
	}
	
	public Iterable<User> getUsers(){
		return userRepo.findAll();
	}
}
