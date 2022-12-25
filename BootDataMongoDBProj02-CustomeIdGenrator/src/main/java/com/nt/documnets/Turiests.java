package com.nt.documnets;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turiests implements Serializable{

	@Id
	private String id;
	private String tname;
	private String nativeAddr;
	private Long contactNo;
	private Float age;
	private Boolean isVaccienated;
	private String passportNol;
}
