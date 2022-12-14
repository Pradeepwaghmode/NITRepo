package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.beans.CustomerInfo;

@SpringBootApplication
public class BootProj05ConfigurationPropertiesAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj05ConfigurationPropertiesAnnotationApplication.class, args);
		
		CustomerInfo cust=ctx.getBean(CustomerInfo.class);
		
		System.out.println(cust);
	}

}
