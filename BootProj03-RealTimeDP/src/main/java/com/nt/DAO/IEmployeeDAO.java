package com.nt.DAO;

import java.util.List;

import com.nt.modal.Employee;

public interface IEmployeeDAO {

	public List<Employee> getEmpByDesg(String desg1,String desg2,String desg3) throws Exception;
}
