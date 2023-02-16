package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Address;
import com.nt.model.Politician;

@RestController
@RequestMapping("/politician/api")
public class PoliticianOpearationController {

//	@GetMapping("/find/{id}")
//	public ResponseEntity<Politician> findPoliticianById(@PathVariable int id){
//		Politician p=new Politician(10, "modi", "BJP", "PM", 60.0);
//		System.out.println("id :: "+id);
//		return new ResponseEntity<Politician>(p,HttpStatus.OK);
//	}
//	
//	@GetMapping("/find")
//	public ResponseEntity<List<Politician>> get(){
//		List<Politician> list=new ArrayList<>();
//		Politician p=new Politician(10, "modi", "BJP", "PM", 60.0);
//		Politician p1=new Politician(11, "Amit Shaha", "BJP", "CM", 62.0);
//		Politician p2=new Politician(12, "Thakare", "Shishena", "CM", 45.0);
//		list.add(p2);list.add(p);list.add(p1);list.add(p2);
//		
//		return new ResponseEntity<List<Politician>>(list,HttpStatus.OK);
//	}
	
	
	@GetMapping("get")
	public ResponseEntity<Politician> getPolitician(){
		Address a=new Address("pune",414203L,"karmala");
		Politician p=new  Politician(11, "Amit Shaha", "BJP", "CM", 62.0,a);
		return new ResponseEntity<Politician> (p,HttpStatus.OK);
	}
}
