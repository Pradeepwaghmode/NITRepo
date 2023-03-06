package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BootAopProj01AdviceClassApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootAopProj01AdviceClassApplication.class, args);
	}

}
