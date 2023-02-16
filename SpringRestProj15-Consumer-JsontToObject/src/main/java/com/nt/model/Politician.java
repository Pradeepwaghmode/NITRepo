package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Politician {
	private int pid;
	private String name;
	private String party;
	private String position;
	private Double age;
	private Address address;
}
