package com.prav.simpleWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	@ResponseBody
	public String greet() {
		
		return "Welcome to My First WebApp!!!";
	}
	
	@RequestMapping("/about")
	@ResponseBody
	public String about() {
		return "I Dont Just Learn, I Implement it";
	}
}
