package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.module.Employee;
import com.nt.service.IEmployeeServiceImpl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Controller
@RequestMapping("/employee")
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
	public String restrationConformation(RedirectAttributes ra, @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeMgmtController.restrationConformation()");
		String msg = service.empRegistor(emp);
		ra.addFlashAttribute("msg", msg);
		return "redirect:report";
	}

	/*@PostMapping("/registrationConformation")
	public String restrationConformation(HttpSession session, @ModelAttribute("emp") Employee emp) {
		String msg = service.empRegistor(emp);
		session.setAttribute("msg", msg);
		return "redirect:report";
	}*/
	
	@GetMapping("/report")
	public String reportGenration(Map<String, Object> map) {
		System.out.println("EmployeeMgmtController.reportGenration()");
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
	public String editEmployee(RedirectAttributes ra, @ModelAttribute("emp") Employee emp) {

		String msg=service.updateEmployee(emp);
		System.out.println("===============================");
		System.out.println(emp);
		ra.addFlashAttribute("msg", msg);
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee( RedirectAttributes ra,@RequestParam(name = "empno")int eno) {
		String msg=service.deleteEmployee(eno);
		ra.addFlashAttribute("msg", msg);
		return "redirect:report";
	}
}
