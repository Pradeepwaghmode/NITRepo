package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer/api")
public class CustomerOperationsController {

	@GetMapping("/save")
	public ResponseEntity<String> showReport(
																	@RequestParam int sno,
																	@RequestParam String sname,
																	@RequestParam String addrs
																		){
		
		return new ResponseEntity<String>(sno+" "+sname+" "+addrs,HttpStatus.OK);
		
	}
}
