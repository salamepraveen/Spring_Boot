package com.prav.SpringSecDemo.service;

import org.springframework.stereotype.Service;

import com.prav.SpringSecDemo.model.Users;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder.BuilderClaims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.*;

@Service
public class JWTService {

	
	private String secretKey="SuperSecretKey";
	
	
	public String generateToken(String username) {
		// TODO Auto-generated method stub
		
		
		
		Map<String,Object> claims=new HashMap<>();
		
		return Jwts.builder()
				.claims().add(claims).subject(username).issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()*60*60*60))
				.and().signWith(getKey()).compact();
		
		
	}

	private Key getKey() {
		// TODO Auto-generated method stub
		byte[] keyBytes =Decoders.BASE64URL.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public String extractUserName(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	public String generateToken(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

}
