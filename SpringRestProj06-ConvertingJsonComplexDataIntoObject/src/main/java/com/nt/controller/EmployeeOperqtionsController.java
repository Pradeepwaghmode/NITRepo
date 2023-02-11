package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.module.Company;
import com.nt.module.Employee;

@RestController
@RequestMapping("employee/api")
public class EmployeeOperqtionsController {

	@PostMapping("/save")
	public ResponseEntity<Employee> show(@RequestBody Employee emp){
		System.out.println("EmployeeOperqtionsController.show()");
		System.out.println("Emp Data :: "+ emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<Company> register(@RequestBody Company emp){
		System.out.println("EmployeeOperqtionsController.register()");
		System.out.println("Emp Data :: "+ emp);
		return new ResponseEntity<Company>(emp, HttpStatus.CREATED);
		
	}
	
}
