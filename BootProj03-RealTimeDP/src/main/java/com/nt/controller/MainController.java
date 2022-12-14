package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.Service.IEmployeeService;
import com.nt.modal.Employee;

@Controller("controller")
public class MainController {

	//add comman type of service class
	@Autowired
	private IEmployeeService service;
	public MainController() {
		System.out.println("MainController.MainController()");
	}
	public List<Employee>  gatherEmpByDesg(String desg1,String desg2,String desg3) throws Exception{
		System.out.println("MainController.gatherEmpByDesg()");
		List<Employee> emp=service.FeatchEmpByDesg(desg1, desg2, desg3);
		return emp;
	} 
}
