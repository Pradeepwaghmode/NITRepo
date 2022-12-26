package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ITouristMgntService;

@Component
public class MongoTestRunner implements CommandLineRunner {

	@Autowired
	ITouristMgntService service;
	@Override
	public void run(String... args) throws Exception {
		
		
		System.out.println("=====================");
		
		//service.findAlldetails("pune").forEach(System.out::println);
		//service.findAlldetailsAndAge("pune",25).forEach(System.out::println);
		//service.findAllTuristByAgeRange(30,40).forEach(System.out::println);

		//service.findAllTuristByNativePlaces("pune","kolkata").forEach(System.out::println);
		
		service.findAlldetailsByNativePlace("pune").forEach( row->{
			
			for(Object col:row) {
				System.out.print(col+" ");
			}
			System.out.println();
		});
		System.out.println("=====================");
		
		
		
	}

}
