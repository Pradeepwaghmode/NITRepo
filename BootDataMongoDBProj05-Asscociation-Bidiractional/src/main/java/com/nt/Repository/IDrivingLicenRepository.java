package com.nt.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.documnets.DrivingLicens;


public interface IDrivingLicenRepository extends MongoRepository<DrivingLicens, Integer> {

	
}
