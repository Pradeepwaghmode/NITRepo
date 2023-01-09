package com.nt.module;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emp")
@SQLDelete(sql = "update emp set status='inactive' where empno=?")
@Where(clause = "status<>'inactive'")
public class Employee implements Serializable{

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "EMP_SEQ",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "gen1" ,strategy = GenerationType.SEQUENCE)
	private Integer empno;
	private String empname;
	private String job;
	private Float salary;
	@Transient
	private String vflag="no";
	private String status;
	private String country="India";
	private String state;
}
