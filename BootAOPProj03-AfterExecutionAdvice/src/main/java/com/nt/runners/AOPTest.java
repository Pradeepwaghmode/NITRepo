package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ShoppingService;

@Component
public class AOPTest implements CommandLineRunner {

	@Autowired
	private ShoppingService service;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( service.shopping(new String[] {"shart", "truser","pant"},new double[] {5000.54,300.55,3434.44}));
		
		
	}

}
