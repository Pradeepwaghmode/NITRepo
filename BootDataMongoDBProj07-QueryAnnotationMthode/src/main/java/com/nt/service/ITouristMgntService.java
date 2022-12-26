
package com.nt.service;

import java.util.List;
import java.util.Properties;

import com.nt.documnets.Turiests;

public interface ITouristMgntService {

	public List<Turiests> findAlldetails(String addr);
	public List<Turiests> findAlldetailsAndAge(String addr,int age);
	public List<Turiests> findAllTuristByAgeRange(int minage,int maxage);
	public List<Turiests> findAllTuristByNativePlaces(String addr1,String addr2);
	
	public List<Object[]> findAlldetailsByNativePlace(String addr);
	public List<Object[]> findAlldetailsByNativePlace(String addr,String addr1,String addr2);
}
