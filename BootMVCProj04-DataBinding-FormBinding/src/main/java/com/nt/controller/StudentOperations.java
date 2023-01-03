package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentOperations {

	@GetMapping
	public String showHomePage() {
		return "welcome";
	}

	@GetMapping("/register")
	public String showForm() {
		return "register_form";
	}

	@PostMapping("/register")
	public String studentRegister(Map<String, Object> map, @ModelAttribute("stud") Student st) {
		System.out.println(st);
		return "display_form";
	}
}
