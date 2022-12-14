package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.module.Employee;
import com.nt.service.IEmployeeServiceImpl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Controller
public class EmployeeMgmtController {

	@Autowired
	IEmployeeServiceImpl service;

	@GetMapping
	public String ShowHome() {
		return "home";
	}

	@GetMapping("/register")
	public String registration(@ModelAttribute("emp") Employee emp) {
		emp.setJob("clerk");
		return "register";
	}

	@PostMapping("/registrationConformation")
	public String restrationConformation(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		String msg = service.empRegistor(emp);
		map.put("msg", msg);
		List<Employee> emp1 = service.getAllEmployee();
		map.put("list", emp1);
		return "report";
	}

	@GetMapping("/report")
	public String reportGenration(Map<String, Object> map) {

		List<Employee> emp = service.getAllEmployee();

		map.put("list", emp);
		return "report";
	}

	@GetMapping("/edit")
	public String editemployee(@RequestParam("empno")int empno, @ModelAttribute("emp") Employee emp) {
		
		Employee emp1=service.getById(empno);
		System.out.println(empno);
		BeanUtils.copyProperties(emp1, emp);
		System.out.println(emp);
		return "edit";
	}

	@PostMapping("/edit")
	public String editEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {

		String msg=service.updateEmployee(emp);
		System.out.println("===============================");
		System.out.println(emp);
		List<Employee> emp1 = service.getAllEmployee();
		map.put("list", emp1);
		map.put("msg",msg);
		return "report";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee( Map<String, Object> map,@RequestParam(name = "empno")int eno) {
		String msg=service.deleteEmployee(eno);
		List<Employee> emp1 = service.getAllEmployee();
		map.put("list", emp1);
		map.put("msg",msg);
		return "report";
	}
}
