package com.nt.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.modul.UserDetails;
import com.nt.service.IUserServiceImpl;

@Controller
@RequestMapping("/bank")
public class BankMagementController {

	@GetMapping
	public String showHome() {
		return "home";
	}

	@GetMapping("/balance")
	public String showbalance(Map<String, Object> map) {
		map.put("balance", new Random().nextInt(10000));
		return "show_balance";
	}

	@GetMapping("/approval")
	public String showLoanApproval(Map<String, Object> map) {
		map.put("loan", new Random().nextInt(10000));
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
