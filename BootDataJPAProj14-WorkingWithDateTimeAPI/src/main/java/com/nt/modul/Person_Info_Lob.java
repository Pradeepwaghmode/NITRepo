package com.nt.modul;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Person_Info_Lob implements Serializable {

	@Id
	@GeneratedValue
	private Integer pid;
	
	@Column(length = 20)
	private String pname;
	
	private boolean married;
	
	@Lob
	private byte[] photo;
	@Lob
	private char[] resume;
	
	
}
