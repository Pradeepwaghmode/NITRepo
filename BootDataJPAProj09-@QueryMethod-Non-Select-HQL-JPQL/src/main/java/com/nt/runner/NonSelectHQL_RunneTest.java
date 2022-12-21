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
	
		System.out.println("================");
		int Result=repo.insertOperation("MarMitenge",5.6f,"2020");
		System.out.println(Result!=0?" Records inserted !! ":" Not Records inserted !!");
	


	}

}
