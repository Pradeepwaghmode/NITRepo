package com.nt.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.documnets.Turiests;

public interface ITouristsRepository extends MongoRepository<Turiests, String> {

	@Query(value="{nativeAddr:{$regex:?0}}")
	public List<Turiests> GetAddrUsingLike(String nativeAddr);
	
	@Query(value="{age:{$gte:?0,$lte:?1}}",count = true)
	public int GetCount(int min,int max);
	
	@Query(value= "{}",sort = "{age:1}")
	public List<Turiests> getAllTurist();
	
	@Query(value = "{age:?0}",delete = true)
	public int deleteByAge(int age);
	
	@Query(value = "{age:{$gte:?0,$lte:?1}}",exists = true)
	public boolean querySatiesFingOrNot(int min,int max);
}
