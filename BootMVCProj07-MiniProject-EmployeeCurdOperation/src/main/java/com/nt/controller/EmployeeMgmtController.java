package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.module.Employee;
import com.nt.service.IEmployeeServiceImpl;

@Controller
public class EmployeeMgmtController {

	@Autowired
	IEmployeeServiceImpl service;

	@GetMapping
	public String ShowHome() {
		return "home";
	}

	@GetMapping("/register")
	public String registration() {

		return "register";
	}

	@PostMapping("/registrationConformation")
	public String restrationConformation(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		String msg = service.empRegistor(emp);
		map.put("msg", msg);
		return "conformation";
	}

	@GetMapping("/report")
	public String reportGenration(Map<String, Object> map) {

		List<Employee> emp = service.getAllEmployee();

		map.put("list", emp);
		return "report";
	}

	@GetMapping("/edit")
	public String editemployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		map.put("empno", emp.getEmpno());
		map.put("empname", emp.getEmpname());
		map.put("salary", emp.getSalary());
		map.put("job", emp.getJob());
		return "edit";
	}

	@PostMapping("/edit")
	public String editEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {

		service.updateEmployee(emp);
		List<Employee> emp1 = service.getAllEmployee();
		map.put("list", emp1);
		return "report";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee( Map<String, Object> map,@RequestParam(name = "empno")int eno) {
		service.deleteEmployee(eno);
		List<Employee> emp1 = service.getAllEmployee();
		map.put("list", emp1);
		return "report";
	}
}
