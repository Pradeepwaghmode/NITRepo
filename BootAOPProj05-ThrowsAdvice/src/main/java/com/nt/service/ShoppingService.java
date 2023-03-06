package com.nt.service;

import org.springframework.stereotype.Component;

@Component
public class ShoppingService {

	public double shopping(String []items,double[] prices) {
		double total=0.0;
		
		if (items==null || prices==null) {
			throw new IllegalArgumentException();
		}
		for(double pmt : prices) {
			total=total+pmt;
		}
		
		return total;
	}
}
