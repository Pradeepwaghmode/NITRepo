package com.nt.runner;


import java.util.List;

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

		List<Movie> movie=repo.serachById(1, 200);
		
		movie.forEach(System.out::println);
		System.out.println("=======================");
		List<Movie> list=repo.selectAll();
		
		list.forEach(System.out::println);
		
		System.out.println("=================");
		
		List<Object[]> obj=repo.serachForCols(4, "2021", "2022", "2023");
		
		obj.forEach(row->{
			for(Object val:row)
			System.out.print(val+"            ");	
			
			System.out.println();
		});
	 	
		System.out.println("=================");
		
		System.out.println("Year 2024 realeas Movie Name : "+repo.SerchSingleCol("2024"));
		
		
		System.out.println("=================");
		
		Object temp=repo.AggrigationOfMovie();
		
		Object[] Result1=(Object[]) temp;
		
		System.out.println("Total no of records : "+Result1[0]);
		System.out.println("Max of Rating : "+Result1[1]);
		System.out.println("Min of Year :"+Result1[2]);
		System.out.println("avrage of rating is : "+Result1[3]);
		System.out.println("Sum of year : "+Result1[4]);
	}
	

}
