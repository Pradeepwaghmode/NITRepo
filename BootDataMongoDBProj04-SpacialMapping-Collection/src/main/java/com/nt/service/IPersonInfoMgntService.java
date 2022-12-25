
package com.nt.service;

import java.util.List;
import java.util.Properties;

import com.nt.documnets.PersonInfo;


public interface IPersonInfoMgntService {

	public String Registor(PersonInfo per);
	public List<PersonInfo> getDetails();
	
}
