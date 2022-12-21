package com.nt.runner;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Repository.IMovieRepo;
import com.nt.views.ResultView;




@Component
public class MovieRunnerTest implements CommandLineRunner {

	@Autowired
	IMovieRepo repo;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("==============================");
		System.out.println("Repository impl class : "+repo.getClass());
		Iterable<ResultView> view=repo.findByYear("2022");
		view.forEach(ve->{
			System.out.println("Dynamic Modul class : "+ve.getClass());
			System.out.println("Mid : "+ve.getMid()+" And Movie Name : "+ve.getmName());
		});
		System.out.println("==============================");
	}

}
