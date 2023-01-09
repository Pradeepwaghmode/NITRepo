package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.module.Employee;
import com.nt.service.IEmployeeServiceImpl;
import com.nt.validation.EmployeeValidator;

@Controller
public class EmployeeMgmtController {

	@Autowired
	IEmployeeServiceImpl service;
	@Autowired
	EmployeeValidator validator;

	@GetMapping
	public String ShowHome() {
		return "home";
	}

	@GetMapping("/register")
	public String registration(@ModelAttribute("emp") Employee emp) {
		emp.setJob("clerk");
		return "register";
	}
	
	@ModelAttribute(name = "contriesInfo")
	public Set<String> getAllContries(){
		System.out.println("EmployeeMgmtController.getAllContries()");
		return service.getContryes();
	}
	
	@PostMapping("/statesurl")
	public String showStatesByCountry(@RequestParam(name ="country")String country,
																		@ModelAttribute(name = "emp")Employee emp,		
																		Map<String,Object> map
																						) {
		System.out.println("EmployeeMgmtController.getStates()");
		List<String> states=service.getAllStates(country);
		System.out.println(emp+"==========================");
		System.out.println(states+"=========================");
		map.put("statesInfo", states);
		return "register";
	}
	@PostMapping("/registrationConformation")
	public String restrationConformation(RedirectAttributes ra, @ModelAttribute("emp") Employee emp,
			BindingResult error) {
//		System.out.println("EmployeeMgmtController.restrationConformation()");
//		System.out.println(emp+"=================================");
		String msg = null;
		if (emp.getVflag().equals("no")) {
			if (error.hasFieldErrors())
				return "register";

			if (emp.getJob().equalsIgnoreCase("hacker")) {
				error.rejectValue("job", "hackers.job");
				return "register";
			}
			if (validator.supports(emp.getClass())) {

				validator.validate(emp, error);
				if (error.hasErrors())
					return "register";
				else
					msg = service.empRegistor(emp);
			}
		}
		msg = service.empRegistor(emp);
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
	public String reportGenration(@PageableDefault(page = 0,size = 3,direction = Sort.Direction.ASC) Pageable pageable,
			Map<String, Object> map) {
		System.out.println("EmployeeMgmtController.reportGenration()");
		Page<Employee> emp = service.getAllEmployeePageData(pageable);

		map.put("list", emp);
		return "report";
	}

	@GetMapping("/edit")
	public String editemployee(@RequestParam("empno") int empno, @ModelAttribute("emp") Employee emp) {

		Employee emp1 = service.getById(empno);
		System.out.println(empno);
		BeanUtils.copyProperties(emp1, emp);
		System.out.println(emp);
		return "edit";
	}

	@PostMapping("/edit")
	public String editEmployee(RedirectAttributes ra, @ModelAttribute("emp") Employee emp, BindingResult error) {
		System.out.println("EmployeeMgmtController.editEmployee()");
		String msg = null;
		System.out.println(emp.getVflag()+"================flag==========");
		
			// checking for type mismatch error
			if (error.hasErrors())
				return "edit";
			
			if (emp.getJob().equalsIgnoreCase("hacker")) {
				error.rejectValue("job", "hackers.job");
				return "edit";
			}
			if (emp.getVflag().equals("no")) {
			if (validator.supports(emp.getClass())) {
				System.out.println("entrr=====================");
				validator.validate(emp, error);
				if (error.hasFieldErrors())
					return "edit";
				
			}
		}
			
				
		msg = service.updateEmployee(emp);
		ra.addFlashAttribute("msg", msg);
		return "redirect:report";
	}

	@GetMapping("/delete")
	public String deleteEmployee(RedirectAttributes ra, @RequestParam(name = "empno") int eno) {
		String msg = service.deleteEmployee(eno);
		ra.addFlashAttribute("msg", msg);
		return "redirect:report";
	}
}
