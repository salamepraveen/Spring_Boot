package com.prav.aopdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prav.aopdemo.service.*;
@RestController
public class PaymentController {
	@Autowired	
	private PaymentService paymentService;
	
	
	@GetMapping("/pay")
	public String pay() {
		
		paymentService.processPayment();
		
		return "Pyament Done";
	}
}
