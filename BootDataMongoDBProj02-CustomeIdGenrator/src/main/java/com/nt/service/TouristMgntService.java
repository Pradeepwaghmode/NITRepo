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
	public String Registor(Turiests turist) {
		// TODO Auto-generated method stub
		return repo.save(turist).getId() + " saved succsefully !!";
	}

	@Override
	public List<Turiests> getDetails() {

		return repo.findAll();
	}

	
}
