package com.nt.modul;

import java.util.Date;

import lombok.Data;

@Data
public class PolitianProfile {

	private Integer pid;
	private String pname;
	private String party;
	private Date dob;
	private Date doj;
	private boolean conspost=false;
}
