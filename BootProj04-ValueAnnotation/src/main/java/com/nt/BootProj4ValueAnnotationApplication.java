package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.beans.Hospital;

@SpringBootApplication
public class BootProj4ValueAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj4ValueAnnotationApplication.class, args);
		
		Hospital h=ctx.getBean("hospital",Hospital.class);
		
		System.out.println(h);
	}

}
