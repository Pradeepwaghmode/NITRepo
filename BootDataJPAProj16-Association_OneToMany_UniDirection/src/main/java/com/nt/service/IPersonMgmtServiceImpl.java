package com.nt.service;

import java.util.List;

import com.nt.modul.Person;
import com.nt.modul.PhoneNumbers;

public interface IPersonMgmtServiceImpl {

	public String RegistorPerson(Person person);
	
	public void LoadDataUsingParent();
	public String deleteParentAndChilds(int pid);
	public String deleteAllPhoneNumbersOfPerson(int pid);
	public String saveOnlyChild(List<PhoneNumbers> phno);
}
