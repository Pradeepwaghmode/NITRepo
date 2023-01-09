package com.nt.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.Repository.EmployeeRepository;
import com.nt.module.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeServiceImpl {

	@Autowired
	private EmployeeRepository repo;
	@Autowired
	private Environment env;

	@Override
	public String empRegistor(Employee emp) {
		// TODO Auto-generated method stub
		if (!(emp == null)) {
			emp.setStatus("active");
			int id = repo.save(emp).getEmpno();
			return " Employee Saved with id : " + id;
		} else
			return " Employee  Not Saved ";
	}

	@Override
	public String updateEmployee(Employee emp) {
		emp.setStatus("active");
		int id=repo.save(emp).getEmpno();
		return id+" Employee is Updated succsefully !! ";
	}
	
	@Override
	public String deleteEmployee(int id) {

		repo.deleteById(id);
		return " Employee id "+id+" is deleted succsefully !!";
	}
	
	@Override
	public Employee getById(int id) {
		Employee emp=repo.findById(id).get();
		return emp;
	}
	
	@Override
	public Page<Employee> getAllEmployeePageData(Pageable pagable) {
		Page<Employee> page=repo.findAll(pagable);
		return page;
	}
	
	@Override
	public Set<String> getContryes() {
	Locale[] locales=Locale.getAvailableLocales();
	Set<String> contriesSet=new TreeSet();
	for(Locale l : locales) {
		contriesSet.add(l.getDisplayCountry());
	}
		return contriesSet;
	}

	@Override
	public List<String> getAllStates(String country) {
		String statenames=env.getRequiredProperty(country);
		//get selected country from enviromnet
		List<String> states=Arrays.asList(statenames.split(","));
		Collections.sort(states);
		System.out.println(states);
		return states;
	}
	
	
}
