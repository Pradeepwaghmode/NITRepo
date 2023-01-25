package com.nt.modle;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="emp")
public class Employee implements Serializable{

	@Id
	@GeneratedValue
	private int EMPNO;
	private String EMPNAME;
	private String JOB;
	private Float SALARY;
	private String STATUS;
	private String COUNTRY;
	private String STATE;
}
