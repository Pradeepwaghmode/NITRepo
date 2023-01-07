package com.nt.module;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Employee implements Serializable{

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "EMP_SEQ",initialValue = 100,allocationSize = 1)
	/*@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE,)*/
	@GeneratedValue(generator = "gen1" ,strategy = GenerationType.SEQUENCE)
	private Integer empno;
	private String empname;
	private String job;
	private Float salary;
	private String vflag="no";
}
