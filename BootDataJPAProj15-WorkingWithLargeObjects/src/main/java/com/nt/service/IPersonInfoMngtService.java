package com.nt.service;

import java.util.List;

import com.nt.modul.Person_Info;

public interface IPersonInfoMngtService {

	public String registerPerson(Person_Info info);
	
	public List<Person_Info> featchAllPersonDetails();
	
}
