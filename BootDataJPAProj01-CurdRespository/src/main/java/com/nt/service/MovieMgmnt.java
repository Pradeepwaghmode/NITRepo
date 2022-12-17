package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//	@Override
//	public Long getMovieCount() {
//		System.out.println("==========================");
//		return repo.count();
//	}

	

	@Override
	public Iterable<Movie> featchAllMovies() {
		
		
		return repo.findAll();
	}

	@Override
	public Iterable<Movie> featchAllMoviesById(List<Integer> listId) {
		// TODO Auto-generated method stub
		
		
		return repo.findAllById(listId); 
	}

	@Override
	public Movie featchMoviById(Integer mid) {
		// TODO Auto-generated method stub
		Optional<Movie> opt=repo.findById(mid);
		if(opt.isPresent())
			return opt.get();
		else
			throw new IllegalArgumentException("Rocord not found !!");
		
	}

	@Override
	public Long getMovieCount() {
		// TODO Auto-generated method stub
		return repo.count();
	}

	@Override
	public boolean serachMovieById(Integer id) {
		// TODO Auto-generated method stub
		
		return false;
	}

}
