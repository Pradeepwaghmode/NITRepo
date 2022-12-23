package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.modul.Person_Info;

public interface IPersonRepo extends JpaRepository<Person_Info, Integer> {

}
