package com.nt.Repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.moduls.Movie;

@Transactional
public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	
	
	@Query("update Movie set rating=:rat where mName=:name")
	@Modifying
	public int updateMoveRatingByName(Float rat,String name);
	
	@Query("delete from Movie where rating=:rating")
	@Modifying
	public int daeleteOperation(Float rating);
 
}
