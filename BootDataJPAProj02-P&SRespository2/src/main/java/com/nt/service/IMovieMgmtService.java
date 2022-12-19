package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nt.moduls.Movie;

public interface IMovieMgmtService {


	public Iterable<Movie> displayMovieById(boolean asc,String... properties);
	public Page<Movie> generateReport(int pageNo,int pageSize,boolean asc,String... properties);
	public void generateDetailReport(int pagesize);
	public List<Movie> SearchMovieByMlovie(Movie movie,boolean asc,String... properties);
	public Movie searchMovieById(Integer id);
	
	
}
