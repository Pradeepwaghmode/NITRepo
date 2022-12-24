package com.nt.modul;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="AM_PERSON_INFO")
@Setter
@Getter
public class Person implements Serializable{
	
	@SequenceGenerator(name = "gen1",allocationSize = 1,initialValue =1000,sequenceName = "PER_SEQ" )
	@GeneratedValue(generator ="gen1",strategy = GenerationType.SEQUENCE )
	@Id
	private Integer pid;
	
	@Column(name="PName",length = 20)
	private String name;
	
	@Column(name = "addr" ,length = 20)
	private String addr;
	
	@OneToMany(targetEntity = PhoneNumbers.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID" ,referencedColumnName = "pid")
	@Column(name="PhoneNo")
	private Set<PhoneNumbers> phoneNumbers;

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", name=" + name + ", addr=" + addr + "]";
	}
	
	

}
