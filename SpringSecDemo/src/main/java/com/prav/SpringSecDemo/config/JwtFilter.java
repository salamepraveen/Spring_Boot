package com.prav.SpringSecDemo.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.prav.SpringSecDemo.service.JWTService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JWTService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Bearer
		String authHeader=request.getHeader("Authorization");
		String token=null;
		String usernmae=null;
		
		if(authHeader!=null & authHeader.startsWith("Bearer ")) {
			token=authHeader.substring(7);
			
			usernmae=jwtService.extractUserName(token);
		}
		
	}
	

}
