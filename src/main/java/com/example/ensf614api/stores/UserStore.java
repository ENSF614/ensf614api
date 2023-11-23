package com.example.ensf614api.stores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ensf614api.dao.UserRepository;
import com.example.ensf614api.models.User;

@Service
@Transactional
public class UserStore {
	
	private UserRepository userRepository;
	
	public UserStore(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Iterable<User> getUsers(){
		return userRepository.findAll();
	}
}
