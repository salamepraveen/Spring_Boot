package com.prav.abcConfig.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prav.abcConfig.engine.Engine;

@Component
public class Car {
	
	private Engine engine;
	
	Car(Engine engine){
		this.engine=engine;
	}
	
	public void drive() {
		engine.start();
		System.out.println("Car is driving...");
	}
}
