package com.nt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentOperations {

	/*@GetMapping("/data")
	public String showHomePage(@RequestParam("sno")int no,@RequestParam("sname") String name){
		System.out.println(no +"   "+name);
		return "welcome";
	}*/
	
	@GetMapping("/data")
	public String showHomePage(@RequestParam int sno,@RequestParam(required = false , defaultValue = "rrr") String sname){
		System.out.println(sno +"   "+sname);
		return "welcome";
	}

}
