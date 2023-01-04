package com.nt.controller;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
	
	/*@GetMapping("/data")
	public String showHomePage(@RequestParam(defaultValue = "12") int sno,@RequestParam(required = false , defaultValue = "rrr") String sname){
		System.out.println(sno +"   "+sname);
		return "welcome";
	}
	*/
	
	/*@GetMapping("/data")
	public String showHomePage(@RequestParam(defaultValue = "12") int sno,@RequestParam(required = false , defaultValue = "rrr") String sname,
			@RequestParam(name="sadd")String sadd[],
			@RequestParam(name="sadd")Set<String> saddSet,
			@RequestParam(name="sadd")List<String> saddList){
		System.out.println(sno +"   "+sname+" "+Arrays.toString(sadd)+" ");
		System.out.println("List:"+saddList);
		System.out.println("set:"+saddSet);
		return "welcome";
	}*/
	
	@GetMapping("/data")
	public String showHomePage(@RequestParam(defaultValue = "12") int sno,@RequestParam(required = false , defaultValue = "rrr") String sname,
			@RequestParam(name="sadd")String sadd
		){
		System.out.println(sno +"   "+sname+" "+sadd+" ");
		
		return "welcome";
	}

}
