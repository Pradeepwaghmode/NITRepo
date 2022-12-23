package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.modul.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class EmployeeService implements IEmpService {

	@Autowired
	private EntityManager manger;

	@Override
	public List<Employee> featchEmpDetailsByDesg(String desg1, String desg2) {

		StoredProcedureQuery query = manger.createStoredProcedureQuery("GET_EMP_BY_JOB", Employee.class);

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

		query.setParameter(1, desg1);
		query.setParameter(2, desg2);

		List<Employee> list = query.getResultList();

		return list;
	}

}
