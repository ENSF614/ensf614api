package com.example.ensf614api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ensf614api.stores.EmailStore;
import com.example.ensf614api.views.EmailDetails;

@CrossOrigin
@RestController
@RequestMapping("/api/Email")
public class EmailController {

	private final EmailStore emailStore;
	
	@Autowired
	public EmailController(EmailStore emailStore) {
		this.emailStore = emailStore;
	}

	@PostMapping("sendEmail")
	public boolean validateCreditCard(@RequestBody EmailDetails details) {
		return emailStore.sendSimpleMail(details);
	}
}
