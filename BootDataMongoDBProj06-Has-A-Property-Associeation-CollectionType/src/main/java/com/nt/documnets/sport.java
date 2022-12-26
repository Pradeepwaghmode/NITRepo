package com.nt.documnets;

import java.util.Arrays;

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
public class sport {

	@Id
	private Integer sid;
	private String sname;
	private String[] kitItems;
	@Override
	public String toString() {
		return "sport [sid=" + sid + ", sname=" + sname + ", kitItems=" + Arrays.toString(kitItems) + "]";
	}
	
	
}
