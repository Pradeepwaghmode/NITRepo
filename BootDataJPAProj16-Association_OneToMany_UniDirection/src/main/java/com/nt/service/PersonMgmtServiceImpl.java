package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.IPersonRepository;
import com.nt.Repository.IPhoneNumberRepository;
import com.nt.modul.Person;
import com.nt.modul.PhoneNumbers;

@Service
public class PersonMgmtServiceImpl implements IPersonMgmtServiceImpl {

	@Autowired
	private IPersonRepository perRepo;
	@Autowired
	private IPhoneNumberRepository phoneRepo;

	
	@Override
	public List<Object[]> featchDataByJoin() {
		
		return perRepo.findUsingJoins();
	}

}
