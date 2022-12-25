
package com.nt.service;

import java.util.List;
import java.util.Properties;

import com.nt.documnets.Turiests;

public interface ITouristMgntService {

	public String Registor(Turiests turist);
	public List<Turiests> getDetails();
	
}
