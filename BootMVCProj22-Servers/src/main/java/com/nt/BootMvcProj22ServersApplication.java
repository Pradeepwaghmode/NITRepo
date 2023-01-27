package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootMvcProj22ServersApplication {

	public static void main(String[] args) {
		
		System.out.println("BootMvcProj22ServersApplication.main()");
		
		ConfigurableApplicationContext ctx=SpringApplication.run(BootMvcProj22ServersApplication.class, args);
		System.out.println("BootMvcProj22ServersApplication.main()");
		
	}

}
