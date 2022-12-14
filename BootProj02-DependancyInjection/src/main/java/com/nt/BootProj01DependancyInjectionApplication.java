package com.nt;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class BootProj01DependancyInjectionApplication {

	@Bean("cal")
	public Calendar creatCal() {
		return Calendar.getInstance();
	}
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj01DependancyInjectionApplication.class, args);
		
		WishMessageGenerator genrator=ctx.getBean(WishMessageGenerator.class);
		
		System.out.println("Result is :: "+genrator.generatMessage("Pradeep"));
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
