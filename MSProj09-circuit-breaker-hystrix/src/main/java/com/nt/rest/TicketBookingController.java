package com.nt.rest;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/ticket/api")
public class TicketBookingController {

	@GetMapping
	@HystrixCommand(fallbackMethod = "dummyBooking",
											commandProperties = {
													@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="7"),
													@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),
													@HystrixProperty(name="circuitBreaker.enabled",value="true")
											}
										)
	public String booking() {
		System.out.println("TicketBookingController.booking()");
		
		
		if(new Random().nextInt(10)<7)
			throw new IllegalArgumentException("something Goes wrong");
		return "ticket is booked succussefully";
	}
	 private int count;
	public String dummyBooking() {
		System.out.println("TicketBookingController.dummyBooking()"+count++);
		return "sorry for inconviance !!";
	}
	
	
	
}
