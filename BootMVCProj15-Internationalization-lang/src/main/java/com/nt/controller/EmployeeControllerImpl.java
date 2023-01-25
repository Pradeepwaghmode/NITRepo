package com.nt.controller;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Employee;

@Controller
public class EmployeeControllerImpl {

	@GetMapping
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/register")
	public String showFormPage(@ModelAttribute("emp") Employee emp) {
		return "register";
	}
	
}
