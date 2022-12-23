package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.IPersonRepo;
import com.nt.modul.Person_Info;

@Service
public class PersonInfoMngtServiceImpl implements IPersonInfoMngtService {

	@Autowired
	private IPersonRepo repo;
	@Override
	public String registerPerson(Person_Info info) {
		// TODO Auto-generated method stub
		return repo.save(info).getPid()+" is saved !! ";
	}

	@Override
	public List<Person_Info> featchAllPersonDetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
