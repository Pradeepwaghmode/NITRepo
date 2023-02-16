package com.nt.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Politician;

//@Component
public class JsonDataConveterRunner implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("------------------Get Method using id--------------");
		String url="http://localhost:8080/politician/api/find/{id}";
		ResponseEntity<String> res=template.exchange(url,HttpMethod.GET, null, String.class,101);
		System.out.println("Body :: "+res.getBody());
		System.out.println("status "+res.getStatusCode() +"  "+res.getStatusCodeValue());
		System.out.println("Headres:: "+res.getHeaders());
		ObjectMapper mapper=new ObjectMapper();
		Politician p=new Politician();
		p=mapper.readValue(res.getBody(), Politician.class);
		System.out.println("politician Object :: "+p);
		
		System.out.println("------------------Get Method List of json in string--------------");
		String url1="http://localhost:8080/politician/api/find";
		ResponseEntity<String> res1=template.exchange(url1,HttpMethod.GET, null, String.class);
		System.out.println("Body :: "+res1.getBody());
		System.out.println("status "+res1.getStatusCode() +"  "+res.getStatusCodeValue());
		System.out.println("Headres:: "+res1.getHeaders());
		System.out.println("------------------------------list of of Politiation object-------------");
		ObjectMapper mapper1=new ObjectMapper();
		Politician p1[];
		p1=mapper1.readValue(res1.getBody(), Politician[].class);
		System.out.println("politician Object :: "+p);
		List<Politician> list=Arrays.asList(p1);
		list.forEach(System.out::println);
		System.out.println("------------------------------unothre way list of of Politiation object-------------");
		List<Politician> list1=mapper1.readValue(res1.getBody(), new TypeReference<List<Politician> > (){});
		list1.forEach(System.out::println);
	}
}
