package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaClient
@PropertySource("com/nt/config/application.properties")
public class MsProj02ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj02ProducerApplication.class, args);
	}

}
