package com.nt.documnets;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonInfo implements Serializable{

	@Id
	private Integer id;

	private String paname;
	
	private String[] favColor;
	
	private List<String> friends;
	
	private Set<Long> contactNo;
	
	private Map<String, Long> acctDetails;
	
	private Properties idDetils;
}

