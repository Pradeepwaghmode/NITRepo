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
	public List<Turiests> findAlldetailsusingLikeop(String addr) {
		// TODO Auto-generated method stub
		return repo.GetAddrUsingLike(addr);
	}
	
	@Override
	public int getCountByAgeRange(int min, int max) {
		// TODO Auto-generated method stub
		return repo.GetCount(min, max);
	}
	
	@Override
	public List<Turiests> getAllDetailsInDeseding() {
		// TODO Auto-generated method stub
		return repo.getAllTurist();
	}
	
	@Override
	public int deleteRcordUsibgAge(int age) {
		// TODO Auto-generated method stub
		return repo.deleteByAge(age);
	}
	
	@Override
	public boolean ageFoundInRangeOrNot(int min, int max) {
		// TODO Auto-generated method stub
		return repo.querySatiesFingOrNot(min, max);
	}
}
