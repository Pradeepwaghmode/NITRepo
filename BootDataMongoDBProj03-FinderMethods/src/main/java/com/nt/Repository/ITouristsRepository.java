package com.nt.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.documnets.Turiests;

public interface ITouristsRepository extends MongoRepository<Turiests, Integer> {

	public List<Turiests> findByTnameOrderByTnameAsc(String tname);
}
