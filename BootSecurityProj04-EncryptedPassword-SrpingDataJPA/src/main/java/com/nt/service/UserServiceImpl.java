package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.repository.UsersRepository;

@Service
public class UserServiceImpl implements IUserServiceImpl {

	@Autowired
	private UsersRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String regeister(com.nt.modul.UserDetails user) {
		// TODO Auto-generated method stub
		String pwd=encoder.encode(user.getPwd());
		user.setPwd(pwd);
		int id =repo.save(user).getUnid();
		return "User is saved with id ::"+id;
	}

}
