package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
													 .antMatchers("/user/register","/user/showLogin").permitAll()
                                                      .antMatchers("/bank/offers").authenticated()
                                                      .antMatchers("/bank/balance").hasAnyAuthority("manager","customer")
                                                      .antMatchers("/bank/approval").hasAuthority("manager")
                                                      .anyRequest().authenticated()
              //.and().httpBasic()
               .and().formLogin().defaultSuccessUrl("/bank/",true)
               .loginPage("/user/showLogin")
               .loginProcessingUrl("/login")
               .failureUrl("/user/showLogin?error")
               
               .and().rememberMe()
               .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/bank/logout"))
               .logoutSuccessUrl("/user/showLogin?logout")
              .and().exceptionHandling().accessDeniedPage("/bank/denied")
              .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
		
	}
}
