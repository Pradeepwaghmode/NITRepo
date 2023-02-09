package com.nt.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageapi")
public class MessageRenderController {

	@GetMapping("/wish")
	public ResponseEntity<String> showMessage(){
		
		System.out.println("MessageRenderController.showMessage()");
		LocalDateTime ldt=LocalDateTime.now();
		
		String msg=null;
		int hour=ldt.getHour();
		if(hour<12)
			msg="Good Morning !!";
		else
		if(hour<16)
			msg="Good AfterNoon !!";
		else
			if(hour<18)
				msg="Good Evening !!";
			else
				msg="Good Night !!";
		
		ResponseEntity<String> entity=new ResponseEntity<String>(msg, HttpStatus.OK);
		return entity;
	}
	@PostMapping("/wish")
	public ResponseEntity<List<String>> showMessage1(){
		
		ResponseEntity<List<String>> entity=new ResponseEntity<List<String>>(List.of("Pradeep","Raje","Nataraj","Ramu"), HttpStatus.OK);
		
		return entity;
	}
	
}
