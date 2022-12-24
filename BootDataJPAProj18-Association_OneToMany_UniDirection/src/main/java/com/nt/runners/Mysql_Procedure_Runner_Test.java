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
		// TODO Auto-generated method stub
//		System.out.println("=====================");
//		PhoneNumbers ph=new PhoneNumbers();
//		
//		ph.setPhoneNo(888888888888L);
//		ph.setPhoneType("office");
//		ph.setProvider("Airtel");
//		
//		PhoneNumbers ph1=new PhoneNumbers();
//		
//		ph1.setPhoneNo(3333333333L);
//		ph1.setPhoneType("Home");
//		ph1.setProvider("VI");
//		
//		
//		PhoneNumbers ph2=new PhoneNumbers();
//		
//		ph1.setPhoneNo(3333333333L);
//		ph1.setPhoneType("Home");
//		ph1.setProvider("VI");
//		
		Person per=new Person();
//		ph1.setPhoneNo(55555555555L);
//		ph1.setPhoneType("OUTSIDE");
//		ph1.setProvider("BSNL");
//		
		per.setName("YEDA");
		per.setAddr("Hyd");
		//per.setPhoneNumbers(Set.of(ph2,ph,ph1));
		System.out.println(service.RegistorPerson(per));
		
		System.out.println("========================");
		
//		System.out.println("=============================");
//		//service.LoadDataUsingParent();
//		//System.out.println(service.deleteParentAndChilds(1002));
//		System.out.println(service.deleteAllPhoneNumbersOfPerson(1000));
//		System.out.println("=============================");
		
		
		System.out.println("=====================");
//		PhoneNumbers ph=new PhoneNumbers();
//		
//		ph.setPhoneNo(77777777777L);
//		ph.setPhoneType("Room");
//		ph.setProvider("Airtel");
//		
//		PhoneNumbers ph1=new PhoneNumbers();
//		
//		ph1.setPhoneNo(66666666L);
//		ph1.setPhoneType("MAJA");
//		ph1.setProvider("VI");
//		
//		
//		PhoneNumbers ph2=new PhoneNumbers();
//		
//		ph1.setPhoneNo(555555555555L);
//		ph1.setPhoneType("SAJA");
//		ph1.setProvider("VI");
//		
//		System.out.println(service.saveOnlyChild(List.of(ph1,ph2,ph)));
		System.out.println("======================");
//		
		
	}

}
