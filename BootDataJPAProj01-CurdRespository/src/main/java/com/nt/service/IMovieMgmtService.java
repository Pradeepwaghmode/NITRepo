package com.nt.service;

import org.yaml.snakeyaml.events.Event.ID;

import com.nt.moduls.Movie;

public interface IMovieMgmtService {

	public String registorMovie(Movie move);
	public Long getMovieCount();
	public boolean serachMovieById(ID id);
}
