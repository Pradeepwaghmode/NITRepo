package com.nt.beans;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {

	@Autowired
	private Calendar  date;
	
	public String generatMessage(String name) {
		
		int hour=date.get(Calendar.HOUR_OF_DAY);
		
		if(hour<12)
			return "Hi "+name+", Good Mornig";
		else if(hour<16)
			return "Hi "+name+", Good AfterNoon";
		else if(hour<20)
			return "Hi "+name+", Good Evening";
		else
			return "Hi "+name+", Good Night";
	}
}
