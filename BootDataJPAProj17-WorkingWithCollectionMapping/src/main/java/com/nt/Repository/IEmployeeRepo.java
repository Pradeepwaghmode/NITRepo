package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.modul.Employee_info;


public interface IEmployeeRepo extends JpaRepository<Employee_info, Integer> {

	
}
