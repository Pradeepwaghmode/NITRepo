package com.nt.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/shoppingMs")
public class ShoppingController {

	@Autowired
	private RestTemplate template;
	
	 public Logger logger=LoggerFactory.getLogger(ShoppingController.class);
	@GetMapping("/shopping")
	public String doShopping() {
	
		logger.info("Shopping just started");
		String msg=template.getForObject( "http://localhost:9902/billingMs", String.class);
		logger.info("shpping is done ");
		return "Shopping is done with :: "+msg;
	}
}
