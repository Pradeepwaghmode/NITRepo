package com.nt.test;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
public class ApplicationRunnerTest implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ApplicationRunnerTest.run() : 0");
		System.out.println("Non optional args : "+args.getNonOptionArgs());
		
		for(String name:args.getOptionNames()) {
			System.out.println("Optional names : "+name);
			
		}

	}

}
