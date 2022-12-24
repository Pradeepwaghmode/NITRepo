package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.modul.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
