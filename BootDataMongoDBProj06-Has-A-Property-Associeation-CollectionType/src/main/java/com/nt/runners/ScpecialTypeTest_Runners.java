package com.nt.runners;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.documnets.Medal;
import com.nt.documnets.Player;
import com.nt.documnets.sport;
import com.nt.service.IPlayerMgmtService;

@Component
public class ScpecialTypeTest_Runners implements CommandLineRunner {

	@Autowired
	IPlayerMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		try {
		sport sp=new sport();
		sp.setSid(new Random().nextInt(10000));
		sp.setSname("cricket");
		sp.setKitItems(new String[] {"bat","bol","glubs","humpier"});
		sport sp2=new sport();
		sp2.setSid(new Random().nextInt(10000));
		sp2.setSname("tenis");
		sp2.setKitItems(new String[] {"roket","cock","net","humpier"});
		
		Medal md=new Medal();
		md.setMid("cwg-silver");
		md.setName("silver");
		md.setEvent("cwg-japan");
		md.setPlace("tokiyo");
		
		Medal md2=new Medal();
		md2.setMid("cwg-Gold");
		md2.setName("Gold");
		md2.setEvent("cwg-japan");
		md2.setPlace("tokiyo");
		
		Player pl=new Player();
		pl.setPid(new Random().nextInt(10000));
		pl.setPaddr("pune");
		pl.setPname("Sindhu");
		pl.setMedal(Map.of("Medle1",md,"medle2",md2));
		pl.setSport(Set.of(sp,sp2));
		
		System.out.println("==============================");

		System.out.println(service.registoredPlayers(pl));
		
		System.out.println("==============================");
		service.FeatchPlayrs().forEach(player->{
			System.out.println("PLAYESRS : "+player);
			Set<sport> sptr=player.getSport();
			sptr.forEach(pr->{
				System.out.println("SPORTS : "+pr);	
			});
			Map<String,Medal> mdl=player.getMedal();
			mdl.forEach((type,medal)->{
				System.out.println("MEDAL NO : "+type);
				System.out.println("MEDAL DETAILS : "+medal);	
			});
		});
		System.out.println("==============================");
		}
		
		catch(Exception e) {
			System.err.println("Some Error is came please check once !!");
			e.printStackTrace();
		}
		
	}

}
