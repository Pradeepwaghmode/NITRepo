package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.MarrageFunction;

@Component
public class AOPTest implements CommandLineRunner {

	@Autowired
	private MarrageFunction service;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( service.dennerArrangement("HK sir", 5));
		
		
	}

}
