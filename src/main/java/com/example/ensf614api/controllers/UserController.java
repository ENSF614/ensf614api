package com.example.ensf614api.controllers;

import com.example.ensf614api.models.SignIn;
import com.example.ensf614api.models.User;
import com.example.ensf614api.stores.UserStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("getUser/{userId}")
	public User getUser(@PathVariable("userId") String userId){return userStore.getUser(userId);}

	@PostMapping("login")
	public ResponseEntity<?> signIn(@RequestBody SignIn details){
		var signedInUser = userStore.signIn(details);

		if (signedInUser == null){
			return ResponseEntity.badRequest().body("Invalid Username or Password");
		}
		return ResponseEntity.ok(signedInUser);
	}

	@PostMapping("newUser")
	public ResponseEntity<?> createNewUser(@RequestBody User newUser){
		if(userStore.doesUserExist(newUser.getEmail())){
			return ResponseEntity.badRequest().body("User already exists");
		}
		return ResponseEntity.ok(userStore.createUser(newUser));
	}
}
