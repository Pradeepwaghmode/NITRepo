package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringRestProj13CunssumerApplicationUsingJsonApplication {

	@Bean(name="template")
	public RestTemplate createTEmplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringRestProj13CunssumerApplicationUsingJsonApplication.class, args);
	}

}
