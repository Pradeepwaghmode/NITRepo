package com.nt.Service;

import java.util.List;

import com.nt.modal.Employee;

public interface IEmployeeService {

	public List<Employee> FeatchEmpByDesg(String desg1,String desg2,String desg3)throws Exception;
}
