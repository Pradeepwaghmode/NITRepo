package com.nt.service;

public interface IBankService {

	public double calcIntrest(double pmt,double rate,double time) ;
	public double calcCoupondIntrest(double pmt,double rate,double time) ;
}
