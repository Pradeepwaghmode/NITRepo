package com.nt.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/billingMs")
public class BillingController {

	@Autowired
	private RestTemplate template;
	
	 Logger logger=LoggerFactory.getLogger(BillingController.class);
	@GetMapping
	public String doShopping() {
	
		logger.info("Billing is just started");
		String msg=template.getForObject( "http://localhost:9903/paymentMs", String.class);
		logger.info("Billing is done ");
		return " , total bill is :: 9300"+ msg;
	}
}
