package com.prav.SpringSecDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prav.SpringSecDemo.model.Users;
import com.prav.SpringSecDemo.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;	
	
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	private JWTService JwtService;
	
	private BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(12) ;
	
	
	
	public Users register(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
		
	}



	public String verify(Users user) {
		// TODO Auto-generated method stub
		Authentication authentication=authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		if(authentication.isAuthenticated()) {
			return JwtService.generateToken(user);
		}else {
			return "fail";
		}
	}
}
