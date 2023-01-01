package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.modul.Modul;

@Controller
public class DataRenderingController {

	/*@GetMapping
	public String show(Map<String, Object> map) {
		map.put("name", "pradeep");
		map.put("addr", "Pune");
		map.put("age", "23");
		
		return "welcome";
	}*/
	
	/*@GetMapping
	public String show(Map<String, Object> map) {
		map.put("name", "pradeep");
		map.put("favColors", new String[] {"red","green","yellow","pink"});
		map.put("nickName", List.of("raja","maharaja","king","prince"));
		map.put("phoneNo", Set.of(333333L,4444444L,5555555L,3333221L));
		map.put("idDetails",Map.of("adhharId",3223323L,"voterId","MH-2323K","panId",3332323));
		
		return "welcome";
	}*/
	
	/*@GetMapping
	public String show(Map<String, Object> map) {
	Modul md=new Modul(1,"Table",25000.0,1.0);
	map.put("prodData",md);
	
		return "Result";
	}*/

	@GetMapping
	public String show(Map<String, Object> map) {
	Modul md1=new Modul(1,"Table",25000.0,1.0);
	Modul md2=new Modul(1,"Fan",27000.0,1.0);
	Modul md3=new Modul(1,"TV",50000.0,1.0);
	Modul md4=new Modul(1,"Bolet",250000.0,1.0);
	map.put("prodData",List.of(md1,md2,md3,md4));
	
		return "Result";
	}
}
