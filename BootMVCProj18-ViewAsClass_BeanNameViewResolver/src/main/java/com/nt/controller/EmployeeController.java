package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.modle.Employee;
import com.nt.service.IEmployeeManagementServiceImpl;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeManagementServiceImpl service;
	
	@GetMapping
	public String showHome() {
		return "welcome";
	}
	
	@GetMapping("/report")
	public String getReport(Map<String,Object> map,@RequestParam("type")String type) {
		
		List<Employee> list=service.getAllEmployee();
		
		map.put("emplist", list);
		if(type.equalsIgnoreCase("excel"))
			return "excelReport";
		else
			return "pdfReport";
		
	}
}
