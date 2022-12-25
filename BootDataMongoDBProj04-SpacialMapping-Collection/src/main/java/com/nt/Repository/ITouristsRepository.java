package com.nt.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.documnets.PersonInfo;


public interface ITouristsRepository extends MongoRepository<PersonInfo, Integer> {

	
}
