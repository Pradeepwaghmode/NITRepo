package com.nt.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.module.Employee;

public interface IEmployeeServiceImpl {

	public String empRegistor(Employee emp);
	public Page<Employee> getAllEmployeePageData(Pageable pagable);
	public String updateEmployee(Employee emp);
	public String deleteEmployee(int id);
	public Employee getById(int id);
	public Set<String> getContryes();
	public List<String> getAllStates(String country);
}