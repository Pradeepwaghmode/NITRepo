package com.nt.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping
	public ResponseEntity<String> getMessge(){
		System.out.println("TestController.getMessge()");
		return new ResponseEntity<String>("Good Morning Pradeep !!", HttpStatus.OK);
	}
}
