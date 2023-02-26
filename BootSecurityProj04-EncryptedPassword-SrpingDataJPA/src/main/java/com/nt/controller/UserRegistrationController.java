package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.modul.UserDetails;
import com.nt.service.IUserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserRegistrationController {

	@Autowired
	private IUserServiceImpl service;
	
	@GetMapping("/register")
	public String registerForm(@ModelAttribute(name="userinfo") UserDetails userinfo) {
	
		return "register_frm";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute(name="userinfo") UserDetails userinfo,Map<String,Object> map) {
	String msg=service.regeister(userinfo);
	map.put("msg", msg);
		return "user_registration_succuss";
	}
	
	@GetMapping("/showLogin")
	public String showloginpage() {
		
		return "custom_login";
	}
}
