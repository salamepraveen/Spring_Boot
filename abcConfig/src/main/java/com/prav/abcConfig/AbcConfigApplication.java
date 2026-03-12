package com.prav.abcConfig;

import org.springframework.context.ApplicationContext;

import com.prav.abcConfig.car.Car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AbcConfigApplication {
	
	public static void loadClass() {
	
	}
	
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(AbcConfigApplication.class, args);
		
		Car newCar=context.getBean(Car.class);
		newCar.drive();
	}

}
