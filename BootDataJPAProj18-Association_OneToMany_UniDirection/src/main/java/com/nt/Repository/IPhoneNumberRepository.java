package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.modul.PhoneNumbers;

public interface IPhoneNumberRepository extends JpaRepository<PhoneNumbers, Integer> {

}
