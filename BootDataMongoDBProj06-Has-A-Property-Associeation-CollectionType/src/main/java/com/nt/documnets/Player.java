package com.nt.documnets;

import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

	@Id
	private Integer pid;
	private String pname;
	private String paddr;
	private Set<sport> sport;
	private Map<String, Medal> medal;
	@Override
	public String toString() {
		return "Player [pid=" + pid + ", pname=" + pname + ", paddr=" + paddr + "]";
	}
	
	
	
}
