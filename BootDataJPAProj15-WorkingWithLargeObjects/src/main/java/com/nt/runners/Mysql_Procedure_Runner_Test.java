package com.nt.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.modul.Person_Info;
import com.nt.service.IPersonInfoMngtService;



@Component
public class Mysql_Procedure_Runner_Test implements CommandLineRunner {

	@Autowired
	private IPersonInfoMngtService service;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("=============================");
		//LocalDateTime t=new LocalDateTimeJavaType();
		Person_Info per=new Person_Info();
		per.setPname("Nataraj");
		per.setPage(30f);
		per.setDOB(LocalDate.of(1980, 12, 16));
		per.setTOB(LocalTime.of(12, 9 , 20));
		per.setDOJ(LocalDateTime.of(2023, 02, 2, 11, 10, 15));
		 
		System.out.println(service.registerPerson(per));
		
		System.out.println("=============================");
		
		service.featchAllPersonDetails().forEach(System.out::println);
		
		

	}

}
