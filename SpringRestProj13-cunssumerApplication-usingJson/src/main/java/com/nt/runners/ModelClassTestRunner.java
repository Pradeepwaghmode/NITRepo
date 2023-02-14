package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ModelClassTestRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated met
		String url="http://localhost:8080/SpringRestProj09-MiniPojectAsLayeredApplication/actor/api/save";
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String body= "{\"actorid\":101,\"actorname\":\"raju\",\"category\":\"neww\",\"mobileNo\":3030303}";
		HttpEntity<String> request=new HttpEntity<String>(body,header);
		
		ResponseEntity<String> res=template.postForEntity(url, request, String.class);
		
		System.out.println("body ::"+res.getBody());
		System.out.println("status code::"+res.getStatusCode());
		System.out.println("headers :: "+res.getHeaders());
	}

}
