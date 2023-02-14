package com.nt.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.model.Actor;

public interface IActorRepository extends JpaRepository<Actor, Integer>{

	
	@Query("from Actor where category in (:c1,:c2) order by actorname")
	public List<Actor> getActorsByCategory(String c1,String c2);
}
