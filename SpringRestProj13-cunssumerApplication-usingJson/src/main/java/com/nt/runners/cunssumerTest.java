package com.nt.runners;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class cunssumerTest implements CommandLineRunner{
@Autowired
private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {
	String url="http://localhost:8080/SpringRestProj09-MiniPojectAsLayeredApplication/actor/api/msg/{no}/{name}";
	
	ResponseEntity<String> res=template.getForEntity(url, String.class, Map.of("no","20","name","raja") );
	
	System.out.println("head ::"+res.getHeaders());
	System.out.println("Body :: "+res.getBody());
	System.out.println("stauts code :: "+res.getStatusCode());
		
	}
}
