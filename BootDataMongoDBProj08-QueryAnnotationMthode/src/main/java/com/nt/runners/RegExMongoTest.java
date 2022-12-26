package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ITouristMgntService;

@Component
public class RegExMongoTest implements CommandLineRunner {

	@Autowired
	ITouristMgntService service;
	@Override
	public void run(String... args) throws Exception {
		
		
		System.out.println("=====================");
	
		//service.findAlldetailsusingLikeop("k").forEach(System.out::println);//contains k
		//service.findAlldetailsusingLikeop("^").forEach(System.out::println);//statting with k
		//service.findAlldetailsusingLikeop("a$").forEach(System.out::println);//ending with a
		
		//System.out.println("Total count is : "+service.getCountByAgeRange(28, 40));
		//service.getAllDetailsInDeseding().forEach(System.out::println);
		/*int Result=service.deleteRcordUsibgAge(28);
		if(Result==1) 
		System.out.println("Result :  "+Result+" Record deleted !!");
		else
		System.out.println("Result : Record Not Found to delete !!");	*/
		
		
		boolean result=service.ageFoundInRangeOrNot(50, 60);
		if(result)
			System.out.println("Records are present for ginven rage !!");
		else
			System.out.println("Records are not present for ginven rage !!");
		System.out.println("=====================");
		
		
		
	}

}
