package com.nt.runners;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.documnets.DrivingLicens;
import com.nt.documnets.Person;
import com.nt.service.ITouristMgntService;

@Component
public class MongoTestRunner implements CommandLineRunner {

	@Autowired
	ITouristMgntService service;
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		System.out.println("=========================");
//		
//		//paren to child
//		DrivingLicens licen=new DrivingLicens();
//		licen.setExpieryDate(LocalDate.now());
//		licen.setLicenType("Two-wheeler");
//		
//		
//		Person per=new Person();
//		per.setPname("Raju");
//		per.setPAddr("pune");
//	//	licen.setPersonDetails(per);
//		per.setLinces(licen);
//		
//		System.out.println(service.Registor(per));
//		
//		service.getDetails().forEach(System.out::println);
//
//		System.out.println("=========================");
		
		
		System.out.println("===================");
		/*try {
		//parent to child
		DrivingLicens licen=new DrivingLicens();
		licen.setExpieryDate(LocalDate.now());
		licen.setLicenType("Two-wheeler");
		licen.setLid(new Random().nextInt(1000));
		
		Person per=new Person();
		per.setPid(new Random().nextInt(1000));
		per.setPname("Raju");
		per.setPAddr("pune");
		licen.setPersonDetails(per);
		//per.setLinces(licen);
		
		System.out.println(service.RegistorLicenToPeron(licen));
		
		
		
		}
		catch(Exception e) {
			System.out.println("Some error is came please check once !!");
			e.printStackTrace();
		}*/
		

		try {
			
			List<DrivingLicens> list=service.getDetailsFromchildAngle();
			
			list.forEach(chil->{
				System.out.println("Child Detsils :: "+chil);
				Person per=chil.getPersonDetails();
				System.out.println("Person :: "+per);
			});
			/*DrivingLicens licen=service.getLicen(181);
			System.out.println(licen);
			System.out.println(licen.getPersonDetails());*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
