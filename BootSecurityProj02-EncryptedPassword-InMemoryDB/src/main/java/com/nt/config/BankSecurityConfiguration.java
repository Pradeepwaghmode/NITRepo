package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BankSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		auth.inMemoryAuthentication().
		passwordEncoder(new BCryptPasswordEncoder())
		.withUser("raja")
		.password("$2a$10$B5xbj1od2prYh3ypOWVCq.6inTZRYg2qCo3REDp.PC1//eVYAR7WO").roles("manager");
		auth.inMemoryAuthentication().withUser("ramesh").password("$2a$10$YnITZ/9rau.bgDShn8/LnePIuVvdAeR2xztr1dOOyodd.j.SegUwO").roles("customer");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/").permitAll()
                                                      .antMatchers("/offers").authenticated()
                                                      .antMatchers("/balance").hasAnyRole("manager","customer")
                                                      .antMatchers("/approval").hasRole("manager")
                                                      .anyRequest().authenticated()
              //.and().httpBasic()
               .and().formLogin()
               .and().rememberMe()
               .and().logout()
              .and().exceptionHandling().accessDeniedPage("/denied")
              .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
	}
}
