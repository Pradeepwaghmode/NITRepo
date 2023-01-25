package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "JOBSEEKERS")
public class JobSeekerInfo implements Serializable{

	@GeneratedValue
	@Id
	private Integer id;
	@Column(length = 50)
	private String jsname;
	@Column(length = 50)
	private String jsaddr;
	@Column(length = 200)
	private String resume;
	@Column(length = 200)
	private String photo;
}
