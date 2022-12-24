package com.nt.modul;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="AM_PHONE_NUMBERS")
@Setter
@Getter
public class PhoneNumbers implements Serializable{

	@GeneratedValue
	@Id
	private Integer regNo;
	
	@Column(length = 10)
	private Long phoneNo;

	@Column(length = 20)
	private String phoneType;
	
	@Column(length = 20)
	private String provider;

	@Override
	public String toString() {
		return "PhoneNumbers [regNo=" + regNo + ", phoneNo=" + phoneNo + ", phoneType=" + phoneType + ", provider="
				+ provider + "]";
	}
	
	
}
