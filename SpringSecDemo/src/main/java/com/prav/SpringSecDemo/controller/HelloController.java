package com.prav.SpringSecDemo.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import java.util.*;
@RestController
public class HelloController {
	
	
	
	
	
  
	@GetMapping("/")
	public String greet(HttpServletRequest request) {
		return "Hello Spring Security"+request.getSession().getId();
	}
	
	@GetMapping("/csrf-token")
	@ResponseBody
	public String getCsrfToken(HttpServletRequest request) {

	    CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");

	    return csrfToken.getToken();
	}
	
	
}
