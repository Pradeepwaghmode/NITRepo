package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.module.Employee;

public interface IEmployeeServiceImpl {

	public String empRegistor(Employee emp);
	public Page<Employee> getAllEmployeePageData(Pageable pagable);
	public String updateEmployee(Employee emp);
	public String deleteEmployee(int id);
	public Employee getById(int id);
}
