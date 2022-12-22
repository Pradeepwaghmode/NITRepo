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
	StoredProcedureQuery query=manager.createStoredProcedureQuery("AUTHINTICATION");
		
	query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
	
	query.setParameter(1,"RAJA");
	query.setParameter(2, "RANI1");
	
	String Result=(String) query.getOutputParameterValue(3);
	System.out.println(Result);
	}

}
