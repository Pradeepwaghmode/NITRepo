package com.nt.runners;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.modul.Person;
import com.nt.modul.PhoneNumbers;
import com.nt.service.IPersonMgmtServiceImpl;

@Component
public class Mysql_Procedure_Runner_Test implements CommandLineRunner {

	@Autowired
	private IPersonMgmtServiceImpl service;
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("======================");
		
		List<Object[]> list=service.featchDataByJoin();
		
		list.forEach(per->{
			for(Object obj:per) {
				System.out.print(obj+" ");
			}
			System.out.println();
		});
		
		System.out.println("======================");
		
		
		
	}

}
