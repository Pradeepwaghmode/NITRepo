package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.beans.Employee;

@SpringBootApplication
public class BootProj06ConfigurationPropertiesAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj06ConfigurationPropertiesAnnotationApplication.class, args);
		
		Employee cust=ctx.getBean(Employee.class);
		
		System.out.println(cust);
	}

}
