package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Repository.IMovieRepo;

@Component
public class NonSelectHQL_RunneTest implements CommandLineRunner {

	@Autowired
	IMovieRepo repo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		System.out.println("================");
//		System.out.println(repo.updateMoveRatingByName(5.5f,"RRR")+" Records Updated !! ");
	
		System.out.println("================");
		System.out.println(repo.daeleteOperation(5.5f)+" Records Deleted !! ");
	


	}

}
