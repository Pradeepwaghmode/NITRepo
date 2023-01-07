package com.nt.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.module.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("EmployeeValidator.validate()");

		Employee emp = (Employee) target;

		if (emp.getEmpname() == null || emp.getEmpname().length() <= 0 || emp.getEmpname().equals("")) {
			errors.rejectValue("empname", "empname.required");
		} else if (emp.getEmpname().length() > 10) {
			errors.rejectValue("empname", "empname.maxlength");
		}

		if (emp.getJob() == null || emp.getJob().length() <= 0 || emp.getJob().equals("")) {
			errors.rejectValue("job", "empjob.required");
		} else if (emp.getJob().length() > 9) {
			errors.rejectValue("job", "empjob.maxlength");
		}

		if (emp.getSalary() == null) {
			errors.rejectValue("salary", "empsal.required");
		} else if (emp.getSalary() <= 1000 && emp.getSalary() >= 500000) {
			errors.rejectValue("salary", "empsal.range");
		}
	}

}
