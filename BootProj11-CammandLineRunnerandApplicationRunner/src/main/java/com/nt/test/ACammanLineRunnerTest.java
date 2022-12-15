package com.nt.test;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(10)
public class ACammanLineRunnerTest implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ACammanLineRunnerTest.run() : 10");
		System.out.println(" CommandLine Runner Test : "+Arrays.toString(args));

	}

}
