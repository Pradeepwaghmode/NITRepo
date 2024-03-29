package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsProj02ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj02ConsumerApplication.class, args);
	}

}
