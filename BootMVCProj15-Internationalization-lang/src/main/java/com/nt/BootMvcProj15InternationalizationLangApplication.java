package com.nt;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProj15InternationalizationLangApplication {

	@Bean("localeResolver")
	public SessionLocaleResolver createResolverObj() {
		SessionLocaleResolver slr=new SessionLocaleResolver();
		slr.setDefaultLocale(new Locale("en","US"));
		return slr;
	}
	
	@Bean
	public LocaleChangeInterceptor createInterceptor() {
		LocaleChangeInterceptor lci=new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj15InternationalizationLangApplication.class, args);
	}

}
