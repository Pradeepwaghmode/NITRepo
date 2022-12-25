
package com.nt.service;

import java.util.List;
import java.util.Properties;

import com.nt.documnets.Turiests;

public interface ITouristMgntService {

	public String Registor(Turiests turist);
	public List<Turiests> getDetails();
	public List<Turiests> shortbyPropertues(boolean asc,String... prop);
	public String UpdatingDcument(Turiests tur);
	public Turiests findById(String id);
	public String deleteById(String id);
}
