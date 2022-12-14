package com.nt.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.DAO.IEmployeeDAO;
import com.nt.modal.Employee;

@Service("empservice")
public class EmployeeService implements IEmployeeService {
//get common type of dao class 
	@Autowired
	private IEmployeeDAO  dao;
	@Override
	public List<Employee> FeatchEmpByDesg(String desg1, String desg2, String desg3) throws Exception {
		// TODO Auto-generated method stub
		List<Employee> emp=dao.getEmpByDesg(desg1, desg2, desg3);
		return emp;
	}

}
