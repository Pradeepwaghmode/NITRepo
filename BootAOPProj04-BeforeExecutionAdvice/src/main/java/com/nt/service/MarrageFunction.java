package com.nt.service;

import org.springframework.stereotype.Component;

@Component
public class MarrageFunction {

	public String dennerArrangement(String gustName,int membrs) {
		return gustName+" is come with is family "+membrs+ "members";
	}
}
