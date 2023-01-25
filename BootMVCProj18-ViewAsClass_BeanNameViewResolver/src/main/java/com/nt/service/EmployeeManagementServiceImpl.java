package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.EmployeeRepo;
import com.nt.modle.Employee;

@Service
public class EmployeeManagementServiceImpl implements IEmployeeManagementServiceImpl{

	@Autowired
	private EmployeeRepo repo;

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
}
