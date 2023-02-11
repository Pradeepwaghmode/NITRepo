package com.nt.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.module.Company;
import com.nt.module.Employee;

@RestController
@RequestMapping("company/api")
public class CompanyController {

	@GetMapping("/company")
	public ResponseEntity<Company> showComapnyDetails(){
		System.out.println("CompanyController.showComapnyDetails()");
		Company company=new Company("hcl","hyd",100,10000000.20,"IT company");
		ResponseEntity<Company> entity=new ResponseEntity<Company>(company, HttpStatus.PARTIAL_CONTENT);
		return  entity;
	}
	
	@PostMapping("/company")
	public ResponseEntity<Employee> show(){
		System.out.println("CompanyController.showComapnyDetails()");
		Company company=new Company("hcl","hyd",100,10000000.20,"IT company");
		Employee emp=new Employee(101,
				"Raja",
				new String[] {"red","green","blue","rgb"},
				List.of("King","maharaja","shahajaha"),
				Set.of(999999L,32323L,232323L,32424556L),
				Map.of("aadhar",3453543L,"OvterId",453535345L),
											false,LocalDateTime.of(1999, 12, 16, 10, 25),
											company);
		
		
		ResponseEntity<Employee> entity=new ResponseEntity<Employee>(emp, HttpStatus.OK);
		return  entity;
	}
	
}
