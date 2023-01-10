package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class WishServiceImpl implements IWishService {

	@Override
	public String genrateMessage() {
		// TODO Auto-generated method stub
		LocalDateTime ldt = LocalDateTime.now();

		int hour = ldt.getHour();

		if (hour < 12)
			return "Good Morning Budy !! ";
		else if (hour < 14)
			return "Good Afternoon Budy !! ";
		else if (hour < 20)
			return "Good Evening Budy !! ";
		else
			return "Good Night Budy !! ";

	}

}
