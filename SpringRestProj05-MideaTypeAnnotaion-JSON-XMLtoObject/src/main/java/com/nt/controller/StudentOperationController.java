package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.module.Student;

@RestController
@RequestMapping("student/api")
public class StudentOperationController {

	@PostMapping("save")
	public ResponseEntity<Student> register(@RequestBody Student stud){
		System.out.println("Student data :: "+stud);
		return new ResponseEntity<Student>(stud,HttpStatus.CREATED);
	}
}
