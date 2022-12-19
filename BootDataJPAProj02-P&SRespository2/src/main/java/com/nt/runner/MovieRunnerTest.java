package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.moduls.Movie;
import com.nt.service.IMovieMgmtService;

@Component
public class MovieRunnerTest implements CommandLineRunner {

	@Autowired
	IMovieMgmtService service;

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("MovieRunnerTest.run()");
//		try {
//			Iterable<Movie> it=service.displayMovieById(false, "mName");
//			
//			it.forEach(System.out::println);
//			
//			System.out.println("Result is "+service.displayMovieById(false, "YEAR"));
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
//		try {
//			Page<Movie> page=service.generateReport(1, 3, false, "mName");
//			System.out.println("========================================");
//			System.out.println(page.getContent());
//			System.out.println("========================================");
//			System.out.println("PageSize() : "+page.getSize());
//			System.out.println("Page  No : "+page.getNumber());
//			System.out.println("Page elemen's size : "+page.getNumberOfElements());
//			System.out.println("Tottal pages : "+page.getTotalPages());
//			System.out.println("isFirst Page : "+page.isFirst());
//			System.out.println("isLast Page : "+page.isLast());
//			System.out.println("getSort Page : "+page.getSort());
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		
//		try {
//			service.generateDetailReport(3);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
//		
//		try {
//			Movie movie=new Movie();
//			
//			movie.setMName("Rana");
//			
//			List<Movie> list=service.SearchMovieByMlovie(movie, false, "mName");
//			
//			list.forEach(System.out::println);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		try {
			System.out.println(service.searchMovieById(954));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
