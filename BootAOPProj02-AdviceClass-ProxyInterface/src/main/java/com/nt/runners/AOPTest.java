package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IBankService;

@Component
public class AOPTest implements CommandLineRunner {

	@Autowired
	private IBankService service;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( service.calcIntrest(60000, 2.0, 12.0));
		System.out.println(service.getClass()+"-----------"+service.getClass().getSuperclass()+"-------------"+service.getClass().getInterfaces());
		System.out.println("----------------------------------------------------------------------------");
		System.out.println(service.calcCoupondIntrest(1000.0, 8.0, 12.5));
		
	}

}
