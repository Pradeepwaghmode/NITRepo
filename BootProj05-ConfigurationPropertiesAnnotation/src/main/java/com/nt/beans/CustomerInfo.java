package com.nt.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(  prefix = "cust")
public class CustomerInfo {

	private String name;
	private	int age;
	private String addr;
	private float billAmount;
}
