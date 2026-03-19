package com.prav.SpringSecDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prav.SpringSecDemo.model.UserPrincipal;
import com.prav.SpringSecDemo.model.Users;
import com.prav.SpringSecDemo.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Users user=repo.findByUsername(username);
		
		if(user==null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Not found user in db");
		}
		return new UserPrincipal(user);
	}

}
