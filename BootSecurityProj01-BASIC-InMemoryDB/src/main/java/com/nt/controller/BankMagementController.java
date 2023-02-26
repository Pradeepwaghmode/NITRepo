package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankMagementController {

	@GetMapping
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/balance")
	public String showbalance() {
		return "show_balance";
	}
	
	@GetMapping("/approval")
	public String showLoanApproval() {
		return "approval";
	}
	
	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}
	
	@GetMapping("/denied")
	public String accessDenied() {
		return "denied";
	}
}
