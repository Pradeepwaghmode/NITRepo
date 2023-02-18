package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaServer
//@PropertySource("com/nt/config/application.properties")
public class MsProj01EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj01EurekaApplication.class, args);
	}

}
