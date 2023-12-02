package com.example.ensf614api.stores;

import com.example.ensf614api.models.SignIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.ensf614api.dao.UserRepository;
import com.example.ensf614api.models.User;

@Service
public class UserStore {

	@Autowired
	private UserRepository userRepo;
	
	public UserStore(UserRepository userRepository) {
		this.userRepo = userRepository;
	}
	
	public Iterable<User> getUsers(){
		return userRepo.findAll();
	}

	public User getUser(String userId){return userRepo.getUser(userId);}

	public User signIn(SignIn details){
		return userRepo.signIn(details.getEmail(), details.getPassword());
	}

	public User createUser(User user){
		return userRepo.save(user);
	}

	public boolean doesUserExist(String email){
		var user = userRepo.doesUserExist(email);
		return (user != null);
	}
	
	public User updateCompanionPass(User user) {
		return userRepo.save(user);
	}


}
