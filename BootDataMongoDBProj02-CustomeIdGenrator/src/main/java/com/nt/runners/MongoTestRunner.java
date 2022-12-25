package com.nt.runners;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.documnets.Turiests;
import com.nt.service.ITouristMgntService;

@Component
public class MongoTestRunner implements CommandLineRunner {

	@Autowired
	ITouristMgntService service;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String id=UUID.randomUUID().toString();
//		tur.setId(id);
		
		
		
		System.out.println("=====================");
		Turiests tur=new Turiests();
		tur.setId(id);
		tur.setAge(25F);
//		tur.setContactNo(77827337L);
//		tur.setIsVaccienated(true);
		tur.setNativeAddr("pune");
		tur.setPassportNol("sdsd22323");
		tur.setTname("Ranu");
		System.out.println(service.Registor(tur));
		System.out.println("=====================");
		
		List<Turiests> list=service.getDetails();
		
		list.forEach(System.out::println);
		System.out.println("=====================");
		
		
	/*	System.out.println("=====================");
		
		service.shortbyPropertues(true, "tname").forEach(System.out::println);
		
		System.out.println("=====================");
		
		System.out.println("=====================");
		
		System.out.println(service.findById("63a7138f3a565166dcf0375c"));
		
		System.out.println("=====================");
		*/
		/*
		System.out.println("=====================");
		Turiests tur=new Turiests();
		tur.setId("63a716a6aed2722f2e198926");
		tur.setTname("Nilesh");
		System.out.println(service.UpdatingDcument(tur));
		
		System.out.println("=====================");
		*/
		
//		System.out.println("=====================");
//		
//		System.out.println(service.deleteById("63a7138f3a565166dcf0375c"));
//		
//		System.out.println("=====================");
//		
		
		
	}

}
