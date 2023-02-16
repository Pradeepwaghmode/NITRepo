package com.nt.Restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;
import com.nt.service.IActorManagementService;

@RestController
@RequestMapping("/actor/api")
public class ActorOperationsController {

	@Autowired
	private IActorManagementService service;

	@PostMapping("/save")
	public ResponseEntity<String> register(@RequestBody Actor act) {

		String msg = service.register(act);

		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<?> getAll() {

		List<Actor> act = service.getAllRecords();
		return new ResponseEntity<List<Actor>>(act, HttpStatus.OK);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getActorById(@PathVariable Integer id) {

		Actor act = service.getActorById(id);
		return new ResponseEntity<Actor>(act, HttpStatus.OK);
	}

	@GetMapping("/get/{s1}/{s2}")
	public ResponseEntity<?> getActorByCategoryes(@PathVariable String s1, @PathVariable String s2) {
		List<Actor> act = service.getActorsBycategory(s1, s2);
		return new ResponseEntity<List<Actor>>(act, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<?> updateActor(@RequestBody Actor act) {
		String msg = service.updateActor(act);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteActor(@PathVariable int id) {
		String msg = service.deleteById(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@PatchMapping("update/{id}/{newno}")
	public ResponseEntity<?> updateActorMobileNo(@PathVariable Integer id, @PathVariable Long newno) {
		String msg = service.updateActorMoNo(id, newno);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@GetMapping("msg/{no}/{name}")
	public ResponseEntity<String> createDummyMessage(@PathVariable(name="no") Integer no,@PathVariable(name="name") String name){
		System.out.println("name :"+name+"  "+"no: "+no);
		return new ResponseEntity<String> ("name :"+name+"  "+"no: "+no,HttpStatus.OK);
	}
	
}
