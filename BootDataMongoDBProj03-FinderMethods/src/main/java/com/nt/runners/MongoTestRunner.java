package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Repository.ITouristsRepository;
import com.nt.documnets.Turiests;
import com.nt.service.ITouristMgntService;

@Component
public class MongoTestRunner implements CommandLineRunner {

	@Autowired
	ITouristMgntService service;
	@Autowired
	private ITouristsRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Turiests> tur=repo.findByTnameOrderByTnameAsc("ParuBai");
		tur.forEach(System.out::println);

		
		
	}

}
