package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootBatchProj01PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootBatchProj01PocApplication.class, args);
	}

}
