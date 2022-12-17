package com.nt.service;

import java.util.ArrayList;
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
	/*public Movie featchMoviById(Integer mid) {
		// TODO Auto-generated method stub
		Optional<Movie> opt=repo.findById(mid);
		if(opt.isPresent())
			return opt.get();
		else
			throw new IllegalArgumentException("Rocord not found !!");
		
	}*/
	
	/*public Movie featchMoviById(Integer mid) {
		return repo.findById(mid).orElseThrow(()->new IllegalArgumentException("Record not Found !!"));
	}*/
	
	public Movie featchMoviById(Integer mid) {
		return repo.findById(mid).orElse(new Movie());
	}

	@Override
	public Long getMovieCount() {
		// TODO Auto-generated method stub
		return repo.count();
	}

	@Override
	public boolean serachMovieById(Integer id) {
		// TODO Auto-generated method stub
		
		return repo.existsById(id);
	}

	@Override
	public Optional<Movie> featchMoviByIdOptional(Integer mid) {
		// TODO Auto-generated method stub
		Optional<Movie> opt=repo.findById(mid);
		return opt.isEmpty()?Optional.empty():opt;
	}

	@Override
	public String groupMovieRegistration(List<Movie> moveList) {
		Iterable<Movie> list=repo.saveAll(moveList);
		List<Integer> listId=new ArrayList();
		list.forEach(e->{
			listId.add(e.getMid());
		});
		return listId.toString();
	}

	@Override
	public String UpdateMovieDetails(Integer id, String name, String year) {
		Optional<Movie> list=repo.findById(id);
		if(list.isPresent())
		{
		Movie movie=list.get();
		movie.setMName(name);
		movie.setYear(year);
		
		repo.save(movie);
		return "Movie update with values : "+movie.toString();
		}
		else
			
		return "Record not found for girven id : "+id;
	}

	@Override
	public String updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		Optional<Movie> opt=repo.findById(movie.getMid());
		if(opt.isPresent()) {
			repo.save(movie);
			return "Record Updated succusefully ";
		}else
		return "Record not found for girven id : "+movie.getMid();
	}

	@Override
	public String updateMovie3(Movie movie) {
		// TODO Auto-generated method stub
		repo.save(movie);
		return "Record Updated succusefully ";
	}

	@Override
	public String deletebyId(Integer id) {
		repo.findById(id).orElseThrow(()->new IllegalArgumentException("Record not Found !!"));
		repo.deleteById(id);
		return "Record Deleted succusefully ";
	}

	@Override
	public String deletedAfterVarifingId(Movie movie) {
		Optional<Movie> opt=repo.findById(movie.getMid());
		if(opt.isPresent()) {
			repo.delete(movie);
		return "Record Deleted succusefully ";
		}else
		return "Record not found for girven id : "+movie.getMid();
	}

	@Override
	public String deletebyIdDirect(Integer id) {
		repo.deleteById(id);
		return  "Record Deleted succusefully ";
	}

}
