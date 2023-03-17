package com.nt.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.consumer.MessageStore;
import com.nt.producer.MessegeProducer;

@Controller
public class Messagecontroller {

	@Autowired
	private MessegeProducer producer;
	@Autowired
	private MessageStore store;
	
	@GetMapping("/send")
	public ResponseEntity<String> sendMessage(@RequestParam(name = "message") String msg){
		
		String msg1=producer.sendMessage(msg);
		
		return new ResponseEntity<String>(msg1,HttpStatus.OK);
		
	}
	
	@GetMapping("/readAll")
	public ResponseEntity<List<String>> getAll() {
		
		List<String> list= store.getMessage();
		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}
}
