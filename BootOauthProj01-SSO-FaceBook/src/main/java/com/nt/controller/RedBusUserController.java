package com.nt.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedBusUserController {

	@GetMapping("/")
	public String showHome() {
		return "<h1>welcome to RedBus.Com</h1>"
				+ "<br><br><a href='/SSOAPP/after/'>please login</a>";
	}
	
	@GetMapping("/after")
	public String afterLogin() {
		return "<h1>Hello, you are succusefully log in!!</h1>";
	}
	
	@GetMapping("/user")
	public Authentication showUserDetails(Principal principal) {
		
		System.out.println("user name :: "+principal.getName());
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		return auth;
		
	}
	
}
