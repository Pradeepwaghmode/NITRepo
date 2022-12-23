package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.modul.Employee;
import com.nt.service.IEmpService;

@Component
public class Mysql_Procedure_Runner_Test implements CommandLineRunner {

	@Autowired
	private IEmpService service;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("=============================");
		
		List<Employee> list=service.featchEmpDetailsByDesg("chap","dev");
		
		list.forEach(System.out::println);

	}

}
