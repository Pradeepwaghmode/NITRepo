package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event.ID;

import com.nt.Repository.IMovieRepo;
import com.nt.moduls.Movie;

@Service
public class MovieMgmnt implements IMovieMgmtService{

	@Autowired
	public IMovieRepo repo;
	
	@Override
	public String registorMovie(Movie move) {

		System.out.println("MovieMgmnt.registorMovie()");
		System.out.println("Beafore move fill "+move);
		
		Movie move1=repo.save(move);
		
		System.out.println("After move fill "+move);
		
		return "Movie is registerted with unique id :: "+move1.getMid();
	}

	@Override
	public Long getMovieCount() {
		System.out.println("==========================");
		return repo.count();
	}

	@Override
	public boolean serachMovieById(ID id) {
		
		return repo.existsById(id);
	}

}
