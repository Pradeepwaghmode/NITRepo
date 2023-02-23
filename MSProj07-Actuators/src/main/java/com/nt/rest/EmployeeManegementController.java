package com.nt.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp/api")
public class EmployeeManegementController {
@Value("${name}")
	private String name;
	@GetMapping
	public ResponseEntity<String> show(){
		System.out.println("EmployeeManegementController.show()");
		return new ResponseEntity<String>("Current time is :: "+new Date(),HttpStatus.OK);
	}
}
