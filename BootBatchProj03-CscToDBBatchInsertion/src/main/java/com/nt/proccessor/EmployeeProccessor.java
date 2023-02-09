package com.nt.proccessor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.modul.Employee;

@Component("empProccesor")
public class EmployeeProccessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee item) throws Exception {

		if (item.getSalary() >= 10000) {
			item.setNetSalary(item.getSalary() + item.getSalary() * 0.4f);
			item.setGrossSalary(item.getSalary() + item.getSalary() * 0.2f);
			return item;
		} else
			return null;
	}
}
