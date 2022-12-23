package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.IPersonRepo;
import com.nt.modul.Person_Info_Lob;

@Service
public class PersonInfoMngtServiceImpl implements IPersonInfoMngtService {

	@Autowired
	private IPersonRepo repo;

	@Override
	public String registerPerson(Person_Info_Lob info) {
		// TODO Auto-generated method stub
		return repo.save(info).getPid() + " is saved !! ";
	}

	@Override
	public List<Person_Info_Lob> featchAllPersonDetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Person_Info_Lob findById(int id) {
		// TODO Auto-generated method stub

		Optional<Person_Info_Lob> op = repo.findById(id);

		if (op.isPresent())
			return op.get();
		else
			return null;
	}

}
