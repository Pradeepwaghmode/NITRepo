package com.nt.rest;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/ticket/api")
public class TicketBookingController {

	@GetMapping
	@HystrixCommand(fallbackMethod = "dummyBooking")
	public String booking() {
		System.out.println("TicketBookingController.booking()");
		int n=new Random().nextInt(10);
		System.out.println(n);
		if(n<5)
			throw new IllegalArgumentException("something Goes wrong");
		return "ticket is booked succussefully";
	}
	
	public String dummyBooking() {
		System.out.println("TicketBookingController.dummyBooking()");
		return "sorry for inconviance !!";
	}
	
	
	
}
