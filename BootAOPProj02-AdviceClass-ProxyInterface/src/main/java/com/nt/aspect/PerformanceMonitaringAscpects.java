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
	@Around(value = "execution(double com.nt.service.IBankService.calc*(..))")
	public Object performance(ProceedingJoinPoint pjp) throws Throwable{
		
		start=System.currentTimeMillis();
		System.out.println("execution started "+System.currentTimeMillis());
		Object[] args=pjp.getArgs();
		if(((Double) args[0])>=50000.0)
		{
		    args[1]=((Double) args[1])-0.5;
		}
		if(((Double)args[0])<=0 || ((Double)args[1])<=0 || ((Double)args[2])<=0 )
			throw new IllegalArgumentException("-ve and 0 numbers are not allowed ");
		Object rtVal=pjp.proceed();
		end=System.currentTimeMillis();
		System.out.println("execution completed "+System.currentTimeMillis());
		System.out.println(pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs())+" has taken " +(end-start)+" ms to complete the execution.");
		System.out.println("with out GST :: "+((Double) rtVal));
		rtVal=((Double) rtVal * 0.5)+((Double) rtVal );
		System.out.println("with 0.5 %   GST :: "+((Double) rtVal));
		return rtVal;
	} 
}
