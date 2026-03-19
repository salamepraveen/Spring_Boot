package com.prav.SpringSecDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prav.SpringSecDemo.model.Users;
import com.prav.SpringSecDemo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		System.out.println("user registered");
		return service.register(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		
		return service.verify(user);
	}
}
