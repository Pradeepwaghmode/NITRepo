package com.nt.service;

import java.util.List;

import org.yaml.snakeyaml.events.Event.ID;

import com.nt.moduls.Movie;

public interface IMovieMgmtService {

	public String registorMovie(Movie move);
	public Long getMovieCount();
	public boolean serachMovieById(Integer id);
	public Iterable<Movie> featchAllMovies();
	public Iterable<Movie> featchAllMoviesById(List<Integer> listId);
	public Movie featchMoviById(Integer mid);
}
