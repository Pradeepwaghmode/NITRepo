package com.nt;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling()
public class BootScheduleProj02UsingSpringApplication {

	public static void main(String[] args) {
		System.out.println("intital start time :: "+new Date());
		SpringApplication.run(BootScheduleProj02UsingSpringApplication.class, args);
		//System.out.println("last end time :: "+new Date());
	}

}
