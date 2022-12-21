package com.nt.Repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.moduls.Movie;

@Transactional
public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	
	@Query(value = "insert into NEW_Movie values (M_Id.NEXTVAL,?,?,?)" ,nativeQuery = true)
	@Modifying
	public int insertOperation(String name,Float rating,String year);
 
}
