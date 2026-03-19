package com.prav_spring.myApp;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyAppApplication {
	
	
	static ApplicationContext context ;
	public static Dev loadClass() {
		
		
		
		Dev obj=context.getBean(Dev.class);
		
		return obj;
	}
	
	public static void main(String[] args) {
		context=SpringApplication.run(MyAppApplication.class, args);
		
		Dev newObj=loadClass();
		newObj.build();
		
	}

}
