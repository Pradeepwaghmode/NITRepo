package com.nt.module;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Company {

	private Integer cNo;
	private String cName;
	private Project project;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dos;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dost;
	@JsonFormat(pattern="HH:mm:ss")
	private LocalTime time;
	
}
