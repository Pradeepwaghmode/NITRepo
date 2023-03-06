package com.nt.aspect;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.nt.Exception.InvalideInoutsException;

@Component
@Aspect
public class ExceptionHandlingAspect {

	@AfterThrowing( value ="execution (double com.nt.service.ShoppingService.shopping(..))",throwing = "e")
	public void cupon(JoinPoint jp,Exception e) throws Throwable{

		System.out.println("ExceptionHandlingAspect.cupon()");
		
		String msg=e+" Exception is rised in "+jp.getSignature()+" with args "+Arrays.deepToString(jp.getArgs());
		
		if(msg!=null) {
			Date date = new Date() ;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
			File file = new File("F:\\CBDTR-EXCEPTION-"+dateFormat.format(date) + ".tsv") ;
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write(msg);
			out.flush();
			out.close();
		
		}
		
		throw new InvalideInoutsException(e.getMessage());
	}
}
