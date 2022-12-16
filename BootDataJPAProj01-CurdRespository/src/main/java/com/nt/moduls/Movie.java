package com.nt.moduls;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="NEW_Movie")
public class Movie implements Serializable {

	@Id
	@Column(name="M_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer mid;
	
	@Column(name="M_NAME" , length=20)
	private String mName;
	
	@Column(name="YEAR" , length=20)
	private String year;
	
	@Column(name="RATING")
	private Float rating;
	
}
