package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BootSecurityProj04BasicInMemoryDbApplication {

	@Bean(name="encoder")
	public BCryptPasswordEncoder createEncoder() {
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		SpringApplication.run(BootSecurityProj04BasicInMemoryDbApplication.class, args);
	}

}