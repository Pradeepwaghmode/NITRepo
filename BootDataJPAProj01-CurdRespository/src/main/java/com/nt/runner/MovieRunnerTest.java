package com.nt.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.moduls.Movie;
import com.nt.service.IMovieMgmtService;

@Component
public class MovieRunnerTest implements CommandLineRunner {

	@Autowired
	IMovieMgmtService service;
	@Override
	public void run(String... args) throws Exception {

		Movie movie=new Movie();
		
		movie.setMName("Rana");
		movie.setYear("2022");
		movie.setRating(4.5f);
		
		try {
			System.out.println("===========output========");
			System.out.println(service.registorMovie(movie));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
