package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IEmlpoyeeInfoMngtService;

@Component
public class Mysql_Procedure_Runner_Test implements CommandLineRunner {

	@Autowired
	private IEmlpoyeeInfoMngtService service;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("=============================");
//		
//		Employee_info emp=new Employee_info();
//		emp.setEname("Raju");
//		emp.setFrineds(List.of("Pravin", "Jay","BApu"));
//		emp.setPhoneNumber(Set.of(888887L,1223233L,234234L));
//		emp.setIdDetails(Map.of("Adhar","9910129818442","VoterId","2343423asd","pan","AFMPW1668K"));
//		try {
//		System.out.println(service.Registore(emp));
//
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		System.out.println("==================");
		
		service.featchAllEMP().forEach(System.out::println);
		
	}

}
