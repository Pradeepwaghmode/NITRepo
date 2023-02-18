package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingServiceConsumerClient;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingController {

	@Autowired
	private IBillingServiceConsumerClient service;
	
	@GetMapping
	public String shopping(){
		
		String msg=service.callGenrateBill().getBody();
		try {
			Thread.sleep(20000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Shpping calulation is done and final billing is :: "+msg;
	}
}
