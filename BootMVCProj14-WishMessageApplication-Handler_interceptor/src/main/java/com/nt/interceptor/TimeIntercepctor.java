package com.nt.interceptor;

import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimeIntercepctor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TimeIntercepctor.preHandle()");
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		System.out.println("current hour is :: "+hour);
		if(hour<9 || hour>15) {
			System.out.println("=============condittion field=-------------========");
			RequestDispatcher rdp=request.getRequestDispatcher("/timeout.jsp");
			rdp.forward(request, response);
			return false;
		}
		
		return true;
	}
}
