package com.nt.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) throws Exception{
		
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String pass1=encoder.encode("rani");
		String pass2=encoder.encode("pune");
		
		System.out.println(pass1);
		System.out.println(pass2);
	}
}
