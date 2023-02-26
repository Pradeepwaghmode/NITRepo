package com.nt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nt.modul.UserDetails;

public interface IUserServiceImpl extends UserDetailsService {

	public String regeister(UserDetails user);
}
