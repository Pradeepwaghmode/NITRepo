package com.nt.Repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.moduls.Movie;


public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	

	@Query("from Movie where mid >=:min and mid<=:max ")
	public List<Movie> serachById(int min , int max);
	@Query("from Movie")
	public List<Movie> selectAll();
	
	@Query("select mName,year from Movie where rating>=:rat and year in (:y1,:y2,:y3) order by mName ASC")
	public List<Object[]> serachForCols(float rat,String y1,String y2,String y3);
	
	@Query("select mName from Movie where year=:year")
	public String SerchSingleCol(String year);
	
	@Query(" select count(*) , max(rating) ,min(year) ,avg(rating),sum(year) from Movie")
	public Object AggrigationOfMovie();
 
}
