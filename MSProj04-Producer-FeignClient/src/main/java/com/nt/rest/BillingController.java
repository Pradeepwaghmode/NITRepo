package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing/api")
public class BillingController {

	@Value("${eureka.instance.instance-id}")
	private String intanceId;
	
	@Value("${server.port}")
	private String port;
	@GetMapping("/info")
	public ResponseEntity<String> genreateBill(){
		
		return new ResponseEntity<String>("Total bill is = total amount - discount (RS.5000)"+"intance id :: "+intanceId+" @port::"+port, HttpStatus.OK);
	}
	
	
}
