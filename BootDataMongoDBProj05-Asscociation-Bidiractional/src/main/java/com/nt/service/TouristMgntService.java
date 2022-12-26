package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.IDrivingLicenRepository;
import com.nt.Repository.IPersonRepository;
import com.nt.documnets.DrivingLicens;
import com.nt.documnets.Person;

@Service
public class TouristMgntService implements ITouristMgntService {

	@Autowired
	private IPersonRepository repo;
	@Autowired
	private IDrivingLicenRepository driveRepo;

	@Override
	public String Registor(Person turist) {
		// TODO Auto-generated method stub
		return repo.save(turist).getPid() + " saved succsefully !!";
	}

	@Override
	public List<Person> getDetails() {

		return repo.findAll();
	}

	@Override
	public String RegistorLicenToPeron(DrivingLicens licen) {
		// TODO Auto-generated method stub
		return driveRepo.save(licen).getLid() + " saved succsefully !!";
	}

	@Override
	public List<DrivingLicens> getDetailsFromchildAngle() {
		// TODO Auto-generated method stub
		return driveRepo.findAll();
		
	}
	
	public DrivingLicens getLicen(int id) {
		
		Optional<DrivingLicens> op=driveRepo.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		}
		else 
			return null;
	}
	
}
