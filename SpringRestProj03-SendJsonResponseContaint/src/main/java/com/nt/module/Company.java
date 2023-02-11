package com.nt.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

	String name;
	String location;
	Integer size;
	Double turnOver;
	String catagary;
	
}
