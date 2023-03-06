package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.BankService;

@Component
public class AOPTest implements CommandLineRunner {

	@Autowired
	private BankService service;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		service.calcIntrest(10000, 8.0, 12.0);
		System.out.println("----------------------------------------------------------------------------");
		service.calcCoupondIntrest(1000.0, 8.0, 12.5);
		
	}

}
