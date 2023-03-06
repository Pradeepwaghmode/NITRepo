package com.nt.aspect;

import java.io.FileWriter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CopanGenrationAspect {

	@AfterReturning(returning = "amt", value = "execution (double com.nt.service.ShoppingService.shopping(..))")
	public void cupon(JoinPoint jp, double amt) throws Throwable{

		String msg=null;
		if (amt > 5000)
			msg = "you aviled 5% discount on your next purches";
		else if (amt > 10000)
			msg = "you aviled 10% discount on your next purches";
		else if (amt > 15000)
			msg = "you aviled 15% discount on your next purches";
		else if (amt > 20000)
			msg = "you aviled 20% discount on your next purches";
		
		if(msg!=null) {
		FileWriter writer=new FileWriter("F:\\cupon.txt");
		writer.write(msg);
		writer.flush();
		writer.close();
		System.out.println("cupon genrated successfully");
		}
		
	}
}
