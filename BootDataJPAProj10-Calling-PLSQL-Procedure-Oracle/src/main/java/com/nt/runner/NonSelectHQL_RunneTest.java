package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Repository.IMovieRepo;
import com.nt.moduls.Movie;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Component
public class NonSelectHQL_RunneTest implements CommandLineRunner {

	@Autowired
	private EntityManager manager;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_MOVIE_BY_YEAR_RANGE", Movie.class);
		
	query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter(3, Movie.class, ParameterMode.REF_CURSOR);
	
	query.setParameter(1,"2020");
	query.setParameter(2, "2021");
	
	List<Movie> list=query.getResultList();
	
	list.forEach(System.out::println);
	}

}
