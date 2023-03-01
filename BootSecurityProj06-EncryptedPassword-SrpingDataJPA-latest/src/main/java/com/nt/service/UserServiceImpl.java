package com.nt.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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
	
		Optional<com.nt.modul.UserDetails> op=repo.findByUname(username);
		if(op.isEmpty())
			throw new IllegalArgumentException("user not found");
		else {
			com.nt.modul.UserDetails details=op.get();
			Set<GrantedAuthority> ga=new HashSet<>();
			for(String role : details.getRoles()) {
				SimpleGrantedAuthority sgm=new SimpleGrantedAuthority(role);
				ga.add(sgm);
			}
			
			User user=new User(details.getUname(), details.getPwd(), ga);
			return user;
		}
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
