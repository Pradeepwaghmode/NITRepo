package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.module.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
