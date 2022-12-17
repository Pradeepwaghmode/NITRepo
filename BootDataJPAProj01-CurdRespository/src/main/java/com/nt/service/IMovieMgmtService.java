package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.moduls.Movie;

public interface IMovieMgmtService {

	public String registorMovie(Movie move);
	public Long getMovieCount();
	public boolean serachMovieById(Integer id);
	public Iterable<Movie> featchAllMovies();
	public Iterable<Movie> featchAllMoviesById(List<Integer> listId);
	public Movie featchMoviById(Integer mid);
	public Optional<Movie> featchMoviByIdOptional(Integer mid);
	public String groupMovieRegistration(List<Movie> moveList);
	public String UpdateMovieDetails(Integer id,String name,String year);
	public String updateMovie(Movie movie);
	public String updateMovie3(Movie movie);
	public String deletebyId(Integer id);
	public String deletebyIdDirect(Integer id);
	public String deletedAfterVarifingId(Movie movie);
	
	
}
