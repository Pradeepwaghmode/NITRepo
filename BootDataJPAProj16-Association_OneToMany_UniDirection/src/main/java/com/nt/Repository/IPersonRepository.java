package com.nt.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.modul.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

	//@Query("SELECT PER.pid,PER.name,PER.addr,PHONE.regNo,PHONE.phoneNo,PHONE.phoneType,PHONE.provider FROM Person PER INNER JOIN PER.phoneNumbers PHONE")
	//@Query("SELECT PER.pid,PER.name,PER.addr,PHONE.regNo,PHONE.phoneNo,PHONE.phoneType,PHONE.provider FROM Person PER LEFT JOIN PER.phoneNumbers PHONE")
	@Query("SELECT PER.pid,PER.name,PER.addr,PHONE.regNo,PHONE.phoneNo,PHONE.phoneType,PHONE.provider FROM Person PER RIGHT JOIN PER.phoneNumbers PHONE")
	public List<Object[]> findUsingJoins();
}
