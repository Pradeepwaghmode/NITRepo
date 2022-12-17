package com.nt.runner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.events.Event.ID;

import com.nt.moduls.Movie;
import com.nt.service.IMovieMgmtService;

@Component
public class MovieRunnerTest implements CommandLineRunner {

	@Autowired
	IMovieMgmtService service;
	@Override
	public void run(String... args) throws Exception {
//		
//		  Movie movie=new Movie();
//		  
//		  movie.setMName("Rana");
//		  movie.setYear("2022");
//		  movie.setRating(4.5f);
//		  
//		  try { System.out.println("===========output========");
//		  System.out.println(service.registorMovie(movie)); }
//		  catch (Exception e) { //
//			  System.out.println("Eception is came---==============");
//		   }
		 
//		try {
//			 System.out.println("Total count :: "+service.getMovieCount());
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
/*		try {
			 System.out.println("Total count :: "+service.serachMovieById(1));
		} catch (Exception e) {
			// TODO: handle exception
		}
		 System.out.println("For find all method");
		 
		 try {
			Iterable<Movie> list=service.featchAllMovies();
			System.out.println("========Foreach method=========");
			list.forEach(Movie->System.out.println(Movie));
			System.out.println("========Enhanced forloop=========");
			for(Movie movie:list){ 
				System.out.println(movie);
						}
			System.out.println("========for each meathod with static reference=========");
			list.forEach(System.out::println);
			
			System.out.println("========for each meathod with static reference + streming =========");
			Arrays.asList(list).stream().forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
		}
		*/
		
		/*try {
			List<Integer> list=new ArrayList();
			list.add(1);
			list.add(2);
			System.out.println("Find by Id : "+service.featchAllMoviesById(list));
			System.out.println("============= as of method ===================");
			System.out.println("Find by id : "+service.featchAllMoviesById(List.of(1,2)));
			System.out.println("============= as list of method ===================");
			System.out.println("Find by id : "+service.featchAllMoviesById(Arrays.asList(2,1)));
			
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
		try {
			System.out.println("===========");
			System.out.println("Feach by single id : "+ service.featchMoviById(5));
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}

	}

}
