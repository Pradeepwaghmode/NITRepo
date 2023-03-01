package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BankSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public  void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.ldapAuthentication().contextSource().url("ldap://localhost:10389/o=nit")
		  .managerDn("uid=admin,ou=system").managerPassword("secret")  // This is to connect to ldap server
		  .and().userSearchBase("ou=users").userSearchFilter("(cn={0})")   //For Auhentication
		  .groupSearchBase("ou=roles").groupSearchFilter("(uniqueMember={0})")
		  .groupRoleAttribute("cn").rolePrefix("ROLE_");   // for  Autthorization
		
				
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/").permitAll()
                                                      .antMatchers("/offers").authenticated()
                                                      .antMatchers("/balance").hasAnyRole("MANAGER","CUSTOMER")
                                                      .antMatchers("/approval").hasRole("CUSTOMER")
                                                      .anyRequest().authenticated()
              //.and().httpBasic()
               .and().formLogin()
               .and().rememberMe()
               .and().logout()
              .and().exceptionHandling().accessDeniedPage("/denied")
              .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
	}
}
