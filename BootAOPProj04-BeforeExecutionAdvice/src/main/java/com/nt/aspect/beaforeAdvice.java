package com.nt.aspect;

import java.util.Scanner;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class beaforeAdvice {

	@Before(value = "execution(java.lang.String com.nt.service.MarrageFunction.denner*(..))")
	public void Permission(JoinPoint jp)  throws Throwable{
		
		String msg=(String)jp.getArgs()[0]+ " is came do you wan to allowe him ? yes/no";
		System.out.println(msg);
		Scanner sc=new Scanner(System.in);
		String input=sc.next();
		if(input.equalsIgnoreCase("no"))
		throw new IllegalAccessException("Get out for here owner is not allowing to you , thank you.");
		
	}
}
