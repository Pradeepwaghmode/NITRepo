package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("com/nt/commans/application.properties")
@EnableEurekaClient
public class MsProj11ShppingSluthZpkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj11ShppingSluthZpkingApplication.class, args);
	}

}
