package com.nt.service;

import org.springframework.stereotype.Component;

@Component
public  class BankServiceImpl implements IBankService{

	@Override
	public double calcIntrest(double pmt,double rate,double time) {
		System.out.println("BankService.calcIntrest()");
		return pmt*rate*time/100;
	}
	
	@Override
	public double calcCoupondIntrest(double pmt,double rate,double time) {
		System.out.println("BankService.calcCoupondIntrest()");
		return (pmt*Math.pow(1+rate/100, time))-pmt;
	}
}
