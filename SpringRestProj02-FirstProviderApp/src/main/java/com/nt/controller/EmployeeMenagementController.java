package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee/api")
public class EmployeeMenagementController {

	@GetMapping("/get")
	public ResponseEntity<String> getModeResquest(){
		System.out.println("EmployeeMenagementController.getModeResquest()");
		return new ResponseEntity<String>("EmployeeMenagementController.getModeResquest()",HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> postModeReq(){
		System.out.println("EmployeeMenagementController.postModeReq()");
		
		return new ResponseEntity<String>("postModeReq()",HttpStatus.CREATED);
	}
	
	@PutMapping("/put")
	public ResponseEntity<String> putModeReq(){
	System.out.println("EmployeeMenagementController.putModeReq()");
		return new ResponseEntity<String>("putModeReq()",HttpStatus.OK);
		}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteModeReq(){
	System.out.println("EmployeeMenagementController.deleteModeReq()");
		return new ResponseEntity<String>("deleteModeReq()",HttpStatus.OK);
		}
	
	@PatchMapping("/patch")
	public ResponseEntity<String> patchModeReq(){
	System.out.println("EmployeeMenagementController.patchModeReq()");
		return new ResponseEntity<String>("patchModeReq()",HttpStatus.OK);
		}
	
}
