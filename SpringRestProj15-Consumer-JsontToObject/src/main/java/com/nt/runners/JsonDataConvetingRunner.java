package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Politician;

@Component
public class JsonDataConvetingRunner implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {

		
		System.out.println("------------------Get Method List of json in string--------------");
		String url="http://localhost:8080/politician/api/get";
		ResponseEntity<String> res=template.exchange(url,HttpMethod.GET, null, String.class);
		System.out.println("Body :: "+res.getBody());
		System.out.println("status "+res.getStatusCode() +"  "+res.getStatusCodeValue());
		System.out.println("Headres:: "+res.getHeaders());
		System.out.println("------------------------------list of of Politiation object-------------");
		ObjectMapper mapper=new ObjectMapper();
		Politician p=mapper.readValue(res.getBody(), Politician.class);
		System.out.println(p);
	}
}
