package com.nt.modul;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue
	private Integer eno;
	
	private String ename;
	
	private String desg;
	
	private Float salary;
}
