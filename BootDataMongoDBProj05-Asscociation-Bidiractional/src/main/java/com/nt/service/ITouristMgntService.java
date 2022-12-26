
package com.nt.service;

import java.util.List;

import com.nt.documnets.DrivingLicens;
import com.nt.documnets.Person;


public interface ITouristMgntService {

	public String Registor(Person turist);
	public String RegistorLicenToPeron(DrivingLicens licen);
	public List<Person> getDetails();
	public List<DrivingLicens> getDetailsFromchildAngle(); 
	public DrivingLicens getLicen(int id) ;
	
	
}
