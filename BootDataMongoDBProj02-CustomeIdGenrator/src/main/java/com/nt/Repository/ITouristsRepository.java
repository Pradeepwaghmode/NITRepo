package com.nt.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.documnets.Turiests;

public interface ITouristsRepository extends MongoRepository<Turiests, Integer> {

}
