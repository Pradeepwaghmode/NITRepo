package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.modul.PolitianProfile;

@Controller
public class ProfileController {

	@GetMapping
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(@ModelAttribute(name = "pp")PolitianProfile poly) {
		return "registration";
	}
	
	@PostMapping("/register")
	public String registorPolitician(@ModelAttribute(name = "pp")PolitianProfile poly,
																Map<String,Object> map) {
		System.out.println(poly);
		map.put("poly",poly);
		return "showResult";
	}
	
	@InitBinder
	public void myDateBinder(WebDataBinder binder) {
		System.out.println("ProfileController.myDateBinder()");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
	}
	
}
