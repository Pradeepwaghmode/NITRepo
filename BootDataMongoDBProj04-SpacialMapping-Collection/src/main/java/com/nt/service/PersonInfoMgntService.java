package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.Repository.ITouristsRepository;
import com.nt.documnets.PersonInfo;


@Service
public class PersonInfoMgntService implements IPersonInfoMgntService {

	@Autowired
	private ITouristsRepository repo;

	@Override
	public String Registor(PersonInfo per) {
		// TODO Auto-generated method stub
		return repo.save(per).getId() + " saved succsefully !!";
	}

	@Override
	public List<PersonInfo> getDetails() {

		return repo.findAll();
	}

	
}
