package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



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
	
	}

}
