package com.prav.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	
	@Before("execution(* com.prav.aopdemo.service.*.*(..))")
	public void logBefore() {
		
		System.out.println("Logging before method execution");
	}
}
