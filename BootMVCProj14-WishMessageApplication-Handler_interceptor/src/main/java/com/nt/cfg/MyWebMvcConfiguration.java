package com.nt.cfg;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nt.interceptor.TimeIntercepctor;
@Component
public class MyWebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry)  {
		// TODO Auto-generated method stub
		System.out.println("MyWebMvcConfiguration.addInterceptors()");
		registry.addInterceptor(new TimeIntercepctor());
	}
}
