package com.nt.modul;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Person_Info {

	@Id
	@GeneratedValue
	private Integer pid;
	
	private String pname;
	
	private Float page;
	
	private LocalDate DOB;
	
	private LocalTime TOB;
	
	private LocalDateTime DOJ;
	
}
