package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.val;

@Component("hospital")
@Data
@PropertySource("info.properties")
public class Hospital {

	@Value("${hspt.name}")
	private String hospitalName;
	@Value("${hspt.age}")
	private int age;
	
	@Value("Netake")
	private String hospitalName1;
	
	@Value("${os.name}")
	private String osName;
	
	@Value("${user.name}")
	private String userName;
	

	
	//@Autowired
	@Value("#{info}")
	private LabTestInfo info;
	
	@Value("#{info.bloodProfilePrice+info.echo2DPrice}")
	private Float labTestBill;
	
	@Value("${Path}")
	private String  path;
}
