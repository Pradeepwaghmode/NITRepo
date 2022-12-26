package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.Repository.ITouristsRepository;
import com.nt.documnets.Turiests;

@Service
public class TouristMgntService implements ITouristMgntService {

	@Autowired
	private ITouristsRepository repo;

	@Override
	public List<Turiests> findAlldetails(String addr) {
		// TODO Auto-generated method stub
		return repo.findByNativeAddr(addr);
	}
	
	@Override
	public List<Turiests> findAlldetailsAndAge(String addr,int age) {
		// TODO Auto-generated method stub
		return repo.findByNativeAddrAndAge(addr, age);
	}
	
	@Override
	public List<Turiests> findAllTuristByAgeRange(int minage, int maxage) {
		// TODO Auto-generated method stub
		return repo.findByAgeRange(minage, maxage);
	}
	
	@Override
	public List<Turiests> findAllTuristByNativePlaces(String addr1, String addr2) {
		// TODO Auto-generated method stub
		return repo.findByNavtiveplace(addr1, addr2);
	}
	
	@Override
	public List<Object[]> findAlldetailsByNativePlace(String addr,String addr2,String addr3) {
		// TODO Auto-generated method stub
		return repo.findByNativeAddrSpecificFieldsInClause(addr,addr2,addr3);
	}
	
	@Override
	public List<Object[]> findAlldetailsByNativePlace(String addr) {
		// TODO Auto-generated method stub
		return repo.findByNativeAddrSpecificFields(addr);
	}
}
