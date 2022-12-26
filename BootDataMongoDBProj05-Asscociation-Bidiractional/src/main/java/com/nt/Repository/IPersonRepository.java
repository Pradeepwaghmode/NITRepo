package com.nt.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.documnets.Person;

public interface IPersonRepository extends MongoRepository<Person, Integer> {

	
}
