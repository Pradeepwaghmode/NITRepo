package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.documnets.Medal;

public interface IMedalRepository extends MongoRepository<Medal, String>{

}
