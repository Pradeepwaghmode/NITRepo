package com.nt.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/paymentMs")
public class PaymentController {

	@Autowired
	private RestTemplate template;
	
	 Logger logger=LoggerFactory.getLogger(PaymentController.class);
	@GetMapping
	public String doShopping() {
	
		logger.info("Payment is just started");
		
		logger.info("payment is done ");
		return " , 9300 paid by google pay succussefully , Thank you.";
	}
}
