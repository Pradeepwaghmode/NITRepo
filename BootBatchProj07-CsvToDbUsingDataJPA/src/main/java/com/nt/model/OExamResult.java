package com.nt.model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Super_Top_Brains")
public class OExamResult {

	@Id
	private Integer id;
	private LocalDate dob;
	private Integer semester;
	private Float percentage;
	
}
