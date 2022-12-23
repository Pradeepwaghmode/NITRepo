package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.IEmployeeRepo;
import com.nt.modul.Employee_info;



@Service
public class EmployeeInfoMngtServiceImpl implements IEmlpoyeeInfoMngtService {

	@Autowired
	private IEmployeeRepo repo;

	

	@Override
	public String Registore(Employee_info emp) {
		// TODO Auto-generated method stub
		
		return "EMPloyee is saved with id : "+repo.save(emp).getEid()+". Thank You ! ";
	}
	
	
	@Override
	public List<Employee_info> featchAllEMP() {
		
		return repo.findAll();
	}

}
