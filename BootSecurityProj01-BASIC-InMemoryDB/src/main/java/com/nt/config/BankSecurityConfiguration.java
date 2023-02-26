package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class BankSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").roles("manager");
		auth.inMemoryAuthentication().withUser("ramesh").password("{noop}rani").roles("customer");
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
