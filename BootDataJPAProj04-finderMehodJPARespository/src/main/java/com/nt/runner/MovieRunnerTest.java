package com.nt.runner;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Repository.IMovieRepo;




@Component
public class MovieRunnerTest implements CommandLineRunner {

	@Autowired
	IMovieRepo repo;
	@Override
	public void run(String... args) throws Exception {

//		repo.findBymNameEquals("Rana").forEach(System.out::println);
//		System.out.println("==============================");
//		repo.findBymNameStartingWith("P").forEach(System.out::println);
//		System.out.println("==============================");
//		repo.findBymNameContainsIgnoreCase("r").forEach(System.out::println);
//		System.out.println("==============================");
//		repo.findBymNameLike("%___%").forEach(System.out::println);
//		System.out.println("==============================");
//		
		repo.findByMidGreaterThanAndRatingLessThan(1,5.0f).forEach(System.out::println);
		System.out.println("==============================");
		
		repo.findBymNameStartingWithAndRatingBetween("R", 4.0f, 5.0f).forEach(System.out::println);
		System.out.println("==============================");
		
		repo.findBymNameNotLikeAndYearIn("R%",List.of("2022","2021")).forEach(System.out::println);
		System.out.println("==============================");
	}

}
