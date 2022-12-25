package com.nt.runners;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Repository.ITouristsRepository;
import com.nt.documnets.PersonInfo;
import com.nt.service.IPersonInfoMgntService;

@Component
public class MongoTestRunner implements CommandLineRunner {

	@Autowired
	IPersonInfoMgntService service;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("=======================");
		Properties p = new Properties();
		p.put("Adhar", "23232332");
		p.put("VoterId", "Ind-2323");
		p.put("DrivingLicen", "lmv2323");

		PersonInfo per = new PersonInfo();
		Integer id = new Random().nextInt(1000);
		per.setId(id);
		String[] fav = new String[3];
		fav[0] = "red";
		fav[1] = "yellow";
		fav[2] = "blue";

		per.setFavColor(fav);
		per.setContactNo(Set.of(33323L, 22332L, 232323L));
		per.setFriends(List.of("Pravin", "Pradeep", "PRiyanka", "Pravati", "Bapu"));
		per.setPaname("Raju");
		per.setAcctDetails(Map.of("UnionBank", 23232323L, "Bank Of India", 232323L));
		per.setIdDetils(p);

		System.out.println(service.Registor(per));

		System.out.println("=======================");

		System.out.println(service.getDetails());
		System.out.println("=======================");

	}

}
