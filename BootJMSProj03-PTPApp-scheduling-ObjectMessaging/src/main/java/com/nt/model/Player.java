package com.nt.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Player implements Serializable{

	private int id;
	private String name;
	private LocalDateTime dob;
	private String bithPalace;
}
