package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp/api")
public class EmployeeOperationController {

	@Value("${db.user}")
	private String username;
	@Value("${db.pwd}")
	private String pwd;
	
	@GetMapping
	public ResponseEntity<String> show(){
		
		return new ResponseEntity<String>("user name :: "+username+" passwoard :: "+pwd,HttpStatus.OK);
	}
}
