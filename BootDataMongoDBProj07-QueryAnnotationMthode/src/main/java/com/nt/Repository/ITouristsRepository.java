package com.nt.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.documnets.Turiests;

public interface ITouristsRepository extends MongoRepository<Turiests, String> {

	@Query(fields = "{}",value = "{nativeAddr:?0}")
	public List<Turiests> findByNativeAddr(String nativeAddr);
	@Query(fields = "{}",value = "{nativeAddr:?0,age:{$gte:?1}}")
	public List<Turiests> findByNativeAddrAndAge(String nativeAddr,int age);
	
	@Query(value = "{age:{$gte:?0,$lte:?1}}")//and condition
	public List<Turiests> findByAgeRange(int min,int max);
	
	@Query(value = "{$or:[{nativeAddr:?0},{nativeAddr:?1}]}")//or condition
	public List<Turiests> findByNavtiveplace(String  addr1,String addr2);
	//----------------------------------------------------------------------
	
	//@Query(fields = "{tname:1,nativeAddr:1,age:1}",value = "{nativeAddr:?0}")
	@Query(fields = "{id:0,tname:1,nativeAddr:1,age:1,contactNo:1}",value = "{nativeAddr:?0}")
	//@Query(fields = "{id:0,tname:1,nativeAddr:1,age:1,contactNo:1}",value = "{nativeAddr:{$in[?0,?1,?2]}}")
	public List<Object[]> findByNativeAddrSpecificFields(String nativeAddr);
	
	
	
		//@Query(fields = "{tname:1,nativeAddr:1,age:1}",value = "{nativeAddr:?0}")
		//@Query(fields = "{id:0,tname:1,nativeAddr:1,age:1,contactNo:1}",value = "{nativeAddr:?0}")
		@Query(fields = "{id:0,tname:1,nativeAddr:1,age:1,contactNo:1}",value = "{nativeAddr:{$in[?0,?1,?2]}}")
		public List<Object[]> findByNativeAddrSpecificFieldsInClause(String nativeAddr0,String nativeAddr1,String nativeAddr2);
				
}
