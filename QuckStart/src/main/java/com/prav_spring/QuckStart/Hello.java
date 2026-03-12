package com.prav_spring.QuckStart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	
	@RequestMapping("/hello")
	public String greet() {
		return "Hello World";
	}
}
