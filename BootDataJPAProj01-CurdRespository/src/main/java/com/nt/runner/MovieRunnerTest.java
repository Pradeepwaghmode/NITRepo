package com.nt.runner;

import java.util.List;
import java.util.Optional;

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

		/*
		 * try { System.out.println("Total count :: "+service.serachMovieById(1)); }
		 * catch (Exception e) { // TODO: handle exception }
		 * System.out.println("For find all method");
		 * 
		 * try { Iterable<Movie> list=service.featchAllMovies();
		 * System.out.println("========Foreach method=========");
		 * list.forEach(Movie->System.out.println(Movie));
		 * System.out.println("========Enhanced forloop========="); for(Movie
		 * movie:list){ System.out.println(movie); }
		 * System.out.println("========for each meathod with static reference========="
		 * ); list.forEach(System.out::println);
		 * 
		 * System.out.
		 * println("========for each meathod with static reference + streming ========="
		 * ); Arrays.asList(list).stream().forEach(System.out::println); } catch
		 * (Exception e) { // TODO: handle exception }
		 */

		/*
		 * try { List<Integer> list=new ArrayList(); list.add(1); list.add(2);
		 * System.out.println("Find by Id : "+service.featchAllMoviesById(list));
		 * System.out.println("============= as of method ===================");
		 * System.out.println("Find by id : "+service.featchAllMoviesById(List.of(1,2)))
		 * ; System.out.println("============= as list of method ===================");
		 * System.out.println("Find by id : "+service.featchAllMoviesById(Arrays.asList(
		 * 2,1)));
		 * 
		 * } catch (Exception e) { // TODO: handle exception }
		 */
		/*
		 * try { System.out.println("===========");
		 * System.out.println("Feach by single id : "+ service.featchMoviById(5)); }
		 * catch (Exception e) { e.printStackTrace(); e.getMessage(); }
		 */

		/*
		 * try { System.out.println("==================");
		 * 
		 * Optional opt=service.featchMoviByIdOptional(5);
		 * 
		 * System.out.println(opt); } catch (Exception e) { // TODO: handle exception }
		 */

//		System.out.println("--================pppppppppp=p");
//		try {
//			String Result = service.groupMovieRegistration(
//					List.of(new Movie("Pushpa", "2022", 5.0f), new Movie("Pushpa", "2022", 5.0f),
//							new Movie(" V ", "2022", 5.0f), new Movie("KGF ", "2022", 5.0f)));
//
//			System.out.println("Movies registroed with id's : [ " + Result + " ]");
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
//		try {
//			
//			System.out.println(service.UpdateMovieDetails(55, "Don", "2001"));
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		try {
//			Movie movie=new Movie("Shivaji","2021",5.0f);
//			movie.setMid(1);
//			System.out.println(service.updateMovie(movie));
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
//		try {
//			Movie movie=new Movie("Shivaji","2022",5.0f);
//			movie.setMid(1);
//			System.out.println(service.updateMovie3(movie));
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		try {
//			System.out.println(service.deletebyId(2));
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		
		try {
			Movie movie=new Movie();
			movie.setMid(952);
			System.out.println(service.deletedAfterVarifingId(movie));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
