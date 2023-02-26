package com.nt.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.modul.UserDetails;

public interface UsersRepository extends JpaRepository<UserDetails, Integer> {

	public Optional<UserDetails> findByUname(String uname);
}
