package com.nt.service;

import java.util.List;

import com.nt.module.Employee;

public interface IEmployeeServiceImpl {

	public String empRegistor(Employee emp);
	public List<Employee> getAllEmployee();
	public void updateEmployee(Employee emp);
	public void deleteEmployee(int id);
}
