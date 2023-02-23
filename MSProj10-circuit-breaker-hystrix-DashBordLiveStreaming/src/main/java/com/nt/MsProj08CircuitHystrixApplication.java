package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@PropertySource("com/nt/config/application.properties")
public class MsProj08CircuitHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj08CircuitHystrixApplication.class, args);
	}

}
