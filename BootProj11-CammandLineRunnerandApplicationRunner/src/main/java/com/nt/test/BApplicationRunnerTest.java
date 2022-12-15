package com.nt.test;

import java.lang.annotation.Annotation;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(-20)
public class BApplicationRunnerTest implements ApplicationRunner,Order {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BApplicationRunnerTest.run() : no value");
		System.out.println("Non optional args : "+args.getNonOptionArgs());
		
		for(String name:args.getOptionNames()) {
			System.out.println("Optional names : "+name);
			
		}

	}

	@Override
	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int value() {
		// TODO Auto-generated method stub
		return -15;
	}

}
