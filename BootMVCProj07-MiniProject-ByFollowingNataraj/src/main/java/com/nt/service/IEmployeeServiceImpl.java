package com.nt.service;

import java.util.List;

import com.nt.module.Employee;

public interface IEmployeeServiceImpl {

	public String empRegistor(Employee emp);
	public List<Employee> getAllEmployee();
	public String updateEmployee(Employee emp);
	public String deleteEmployee(int id);
	public Employee getById(int id);
}
