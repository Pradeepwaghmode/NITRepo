package com.nt.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Repository.IMovieRepo;
import com.nt.moduls.Movie;




@Component
public class MovieRunnerTest implements CommandLineRunner {

	@Autowired
	IMovieRepo repo;
	@Override
	public void run(String... args) throws Exception {
//		System.out.println("==============================");
//		//System.out.println("Repository impl class : "+repo.getClass());
//		Iterable<ResultView1> view=repo.findByYear("2022",ResultView1.class);
//		view.forEach(ve->{
//		//	System.out.println("Dynamic Modul class : "+ve.getClass());
//			System.out.println("Mid : "+ve.getMid()+" And Movie Name : "+ve.getmName());
//		});
//		System.out.println("==============================");
//		
//		System.out.println("==============================");
//		//System.out.println("Repository impl class : "+repo.getClass());
//		Iterable<ResultView2> view1=repo.findByYear("2022",ResultView2.class);
//		view1.forEach(ve->{
//			//System.out.println("Dynamic Modul class : "+ve.getClass());
//			System.out.println(" "+ve.getMid()+" "+ve.getmName()+" "+ve.getRating());
//		});
//		System.out.println("==============================");
//		
//		
//		
//		System.out.println("==============================");
//		//System.out.println("Repository impl class : "+repo.getClass());
//		Iterable<ResultView3> view3=repo.findByYear("2022",ResultView3.class);
//		view3.forEach(ve->{
//			//System.out.println("Dynamic Modul class : "+ve.getClass());
//			System.out.println(" "+ve.getMid()+" "+ve.getmName()+" "+ve.getYear());
//		});
//		System.out.println("==============================");
		
		
		System.out.println("=======================");
		Movie move=new Movie();
		move.setMName("Swadesh");
		move.setRating(4.0f);
		move.setYear("2023");
			System.out.println(repo.save(move).getMid() +" is saved");
	}

}
