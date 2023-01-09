package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
}
