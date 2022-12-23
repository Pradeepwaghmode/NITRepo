package com.nt.service;

import java.util.List;

import com.nt.modul.Person_Info_Lob;

public interface IPersonInfoMngtService {

	public String registerPerson(Person_Info_Lob info);
	
	public List<Person_Info_Lob> featchAllPersonDetails();
	
	public Person_Info_Lob findById(int id);
	
}
