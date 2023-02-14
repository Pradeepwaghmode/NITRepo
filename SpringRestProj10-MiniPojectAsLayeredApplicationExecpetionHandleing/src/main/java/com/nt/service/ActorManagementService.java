package com.nt.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Exception.ActorNotFound;
import com.nt.Respository.IActorRepository;
import com.nt.model.Actor;

@Service
public class ActorManagementService implements IActorManagementService {

	@Autowired
	private IActorRepository repo;

	@Override
	public String register(Actor act) {
		int id = repo.save(act).getActorid();
		return "Actor is saved with id ::  " + id;

	}

	/*@Override
	public List<Actor> getAllRecords() {
		List<Actor> list=repo.findAll();
		list.sort((t1,t2)->t1.getActorname().compareTo(t2.getActorname()));
		return list;
	}
	*/

	@Override
	public List<Actor> getAllRecords() {
		List<Actor> list = repo.findAll();
		Collections.sort(list, (t1, t2) -> t1.getActorname().compareTo(t2.getActorname()));
		return list;
	}

	@Override
	public Actor getActorById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("actor id :: "+id+" is not found in our DB .."));
	}

	@Override
	public List<Actor> getActorsBycategory(String c1, String c2) {
		// TODO Auto-generated method stub
		return repo.getActorsByCategory(c1, c2);
	}

	@Override
	public String updateActor(Actor act) {
		boolean s = repo.existsById(act.getActorid());
		if (s) {
			repo.save(act);
			return "actor Record is saved with data :: " + act;
		} else {
			throw new ActorNotFound("Actor not found ");
		}
	}

	@Override
	public String deleteById(int id) {
		boolean s=repo.existsById(id);
		if(s) {
			repo.deleteById(id);
			return "The id "+id+" is deleted successfully";
		}
		else {
		throw new ActorNotFound("Actor id "+id+" is not present in our db please check onece.");
		}
	}
	
	@Override
	public String updateActorMoNo(int id,Long newMobileNo) {
		 Optional<Actor> s = repo.findById(id);
		if (s.isPresent()) {
			Actor act=s.get();
			act.setMobileNo(newMobileNo);
			repo.save(act);
			return "actor Record is saved with data :: " + act;
		} else {
			throw new ActorNotFound("Actor not found ");
		}
	}
}
