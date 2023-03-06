package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitaringAscpects {

	private long start,end;
	@Around(value = "execution(double com.nt.service.BankService.calc*(..))")
	public Object performance(ProceedingJoinPoint pjp) throws Throwable{
		
		start=System.currentTimeMillis();
		System.out.println("execution started "+System.currentTimeMillis());
		Object rtVal=pjp.proceed();
		end=System.currentTimeMillis();
		System.out.println("execution completed "+System.currentTimeMillis());
		System.out.println(pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs())+" has taken " +(end-start)+" ms to complete the execution.");
		return rtVal;
	} 
}
