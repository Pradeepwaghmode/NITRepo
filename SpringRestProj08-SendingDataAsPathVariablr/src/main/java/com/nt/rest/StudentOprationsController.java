package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student/api")
public class StudentOprationsController {

	@GetMapping("/save/{sno}/{sname}")
	public ResponseEntity<String> register( @PathVariable (name="sno",required=false) Integer no,@PathVariable(required = false)  String sname){
		System.out.println(no+"<-------------->"+sname);
		return new ResponseEntity<String>(no+"<-------------->"+sname,HttpStatus.OK);
	}
}
