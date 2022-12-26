
package com.nt.service;

import java.util.List;
import java.util.Properties;

import com.nt.documnets.Turiests;

public interface ITouristMgntService {

	public List<Turiests> findAlldetailsusingLikeop(String addr);
	
	public int getCountByAgeRange(int min,int max);
	
	public List<Turiests> getAllDetailsInDeseding();
	
	public int deleteRcordUsibgAge(int age);
	
	public boolean ageFoundInRangeOrNot(int min,int max);
	
}
