package com.nt.documnets;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class DrivingLicens {

	@Id
	
	private Integer lid;
	@lombok.NonNull
	private String licenType;
	
	@lombok.NonNull
	private LocalDate expieryDate;
	
	private Person personDetails;

	@Override
	public String toString() {
		return "DrivingLicens [lid=" + lid + ", licenType=" + licenType + ", expieryDate=" + expieryDate + "]";
	}
	
	
}
