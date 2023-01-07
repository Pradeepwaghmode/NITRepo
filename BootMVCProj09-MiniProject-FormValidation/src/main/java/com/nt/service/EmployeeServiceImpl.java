package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.EmployeeRepository;
import com.nt.module.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeServiceImpl {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public String empRegistor(Employee emp) {
		// TODO Auto-generated method stub
		if (!(emp == null)) {
			emp.setVflag("no");
			int id = repo.save(emp).getEmpno();
			return " Employee Saved with id : " + id;
		} else
			return " Employee  Not Saved ";
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> emp = repo.findAll();
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		emp.setVflag("no");
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
}
