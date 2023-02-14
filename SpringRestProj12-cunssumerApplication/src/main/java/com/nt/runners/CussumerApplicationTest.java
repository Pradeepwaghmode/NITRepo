package com.nt.runners;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nt.modul.Actor;


@Component
public class CussumerApplicationTest implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	
	 @Override
	public void run(String... args) throws Exception {
		String url="http://localhost:8080/SpringRestProj12-cussumerApplication/actor/api/save/{no}/{name}";
		ResponseEntity<String> res=template.getForEntity(url, String.class,Map.of("no",300,"name","raja"));
		System.out.println("Response Body :: "+res.getBody());
		System.out.println("Status :: "+res.getStatusCode());
		System.out.println("response header :: "+res.getHeaders());
	}
	
}
