package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingMS")
public class ShoppingController {

	Logger logger=LoggerFactory.getLogger(ShoppingController.class);
	
	@GetMapping("/shopping")
	public String doShopping() {
		
		logger.info("shopping is just started ");
		logger.info("shopping is just started ");
		logger.info("shopping is just started ");
		logger.info("shopping is just started ");
		logger.info("shopping is just started ");
		logger.info("shopping is just started ");
		logger.info("shopping is just started ");
		logger.info("======================");
		logger.info("Shopping is finaly ended");
		logger.info("Shopping is finaly ended");
		logger.info("Shopping is finaly ended");
		logger.info("Shopping is finaly ended");
		logger.info("Shopping is finaly ended");
		logger.info("Shopping is finaly ended");
		logger.info("Shopping is finaly ended");
		
		
		return "<h1><b>shopping is Done with 5000Rs, thank you</b></h1>";
	}	
	
}
