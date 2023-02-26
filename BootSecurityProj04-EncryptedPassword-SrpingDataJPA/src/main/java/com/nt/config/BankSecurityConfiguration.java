package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nt.service.IUserServiceImpl;

@Configuration
public class BankSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private IUserServiceImpl service;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		auth.userDetailsService(service).passwordEncoder(encoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/bank/").permitAll()
													 .antMatchers("/user/register").permitAll()
                                                      .antMatchers("/bank/offers").authenticated()
                                                      .antMatchers("/bank/balance").hasAnyRole("manager","customer")
                                                      .antMatchers("/bank/approval").hasRole("manager")
                                                      .anyRequest().authenticated()
              //.and().httpBasic()
               .and().formLogin()
               .and().rememberMe()
               .and().logout()
              .and().exceptionHandling().accessDeniedPage("/denied")
              .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
	}
}
