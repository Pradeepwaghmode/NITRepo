package com.nt.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(  prefix = "per.info"  )
public class Employee {

	private String name;
	private	int age;
	//array type
	private String[] favColours;
	
	//list 
	private List<String> studies;
	
	//set
	
	private Set<Long>  phoNo;
	
	//map
	
	private Map<String,Object> personal;
	
	//has a properties
	private Company comp;
	

}
