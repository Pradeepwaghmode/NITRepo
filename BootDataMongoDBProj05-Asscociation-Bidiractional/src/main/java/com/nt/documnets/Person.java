package com.nt.documnets;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class Person implements Serializable{

	@Id
	@lombok.NonNull
	private Integer pid;
	@lombok.NonNull
	private String pname;
	@lombok.NonNull
	private String pAddr;

	private DrivingLicens linces;

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", pAddr=" + pAddr + "]";
	}
	
	
}
