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

	@Override
	public List<Turiests> shortbyPropertues(boolean asc, String... prop) {
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, prop);
		return repo.findAll(sort);
	}

	@Override
	public Turiests findById(String id) {
		Optional<Turiests> op = repo.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else
			return null;
	}

	@Override
	public String UpdatingDcument(Turiests tur) {
		Optional<Turiests> op = repo.findById(tur.getId());
		if (op.isPresent()) {
			Turiests turi = op.get();
			turi.setTname(tur.getTname());
			Turiests result = repo.save(turi);
			return "Your data updated with : " + result;
		} else
			return "Document not found !! ";

	}

	@Override
	public String deleteById(String id) {
		Optional<Turiests> op = repo.findById(id);
		if (op.isPresent()) {
			repo.deleteById(id);
			return "Record deleted succusefully !!";
		}
		else
		return "Record not found !!";
	}
}
