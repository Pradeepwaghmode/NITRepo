package com.nt.module;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class Employee {

	private Integer empno;
	private String empname;
	private Address empAddrs;
	private List<String> nickNames;
	private Set<Long> phoNo;
	private Map<String,Long> idDetails;
	private LocalDateTime dob;
	
}
