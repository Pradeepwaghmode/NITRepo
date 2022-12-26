package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.documnets.sport;

public interface ISportRepository extends MongoRepository<sport, Integer>{

}
