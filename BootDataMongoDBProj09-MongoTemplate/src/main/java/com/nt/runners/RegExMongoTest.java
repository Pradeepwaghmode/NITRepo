package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IStockMgntService;

@Component
public class RegExMongoTest implements CommandLineRunner {

	@Autowired
	IStockMgntService service;
	@Override
	public void run(String... args) throws Exception {
		
		
		System.out.println("=====================");
	
		/*StockDetail sdtl=new StockDetail(new Random().nextInt(1000), "ICIC", 99999F, "BSE");
		System.out.println("Result is : "+service.registorStockDetails(sdtl));*/
		
		
		/*StockDetail sdtl=new StockDetail(new Random().nextInt(1000), "ICIC", 99999F, "BSE");
		StockDetail sdt2=new StockDetail(new Random().nextInt(1000), "SBI", 99923F, "BSE");
		StockDetail sdt3=new StockDetail(new Random().nextInt(1000), "LIC", 45453F, "BSE");
		StockDetail sdt4=new StockDetail(new Random().nextInt(1000), "TATA", 9999998F, "BSE");
		System.out.println("Result is : "+service.registerStockDetailBatch(List.of(sdtl,sdt2,sdt3,sdt4)));*/
		
		//service.searchByexcechangeName("BSE").forEach(System.out::println);
		
		//service.serchByStockPriceInRange(500, 10000).forEach(System.out::println);
		
		//System.out.println(service.featchStockDtailsByStokID(561));
		
		//System.out.println(service.findAndUpdateById(561));
		
		//System.out.println(service.modifingExchnageByStockPriceRange(500.0, 5000.0, "NYKSE"));
		
		//System.out.println(service.RegisterOrUpdateByStockName("Accenture",7000.0, "ASE"));
		
		//System.out.println(service.featchAndRemoveTheDocumentByStockName("Accenture"));
		
		System.out.println(service.FeatchAndRemoveAllByStockName("ICIC"));
		System.out.println("=====================");
		
		
		
		
		
	}

}
