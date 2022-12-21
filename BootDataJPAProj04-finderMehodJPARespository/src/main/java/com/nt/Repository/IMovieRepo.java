package com.nt.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.moduls.Movie;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	

//	public List<Movie> findBymNameEquals(String mName);
//	
//	public List<Movie> findBymNameStartingWith(String mName);
//	
//	public List<Movie> findBymNameContainsIgnoreCase(String mName);
//	
//	public List<Movie> findBymNameLike(String mName);
	
	
	public List<Movie> findByMidGreaterThanAndRatingLessThan(Integer mid,float rating);
	
	public List<Movie> findBymNameStartingWithAndRatingBetween(String statrChar,float startingRating,float endingRating);
	
	public List<Movie> findBymNameNotLikeAndYearIn(String mName,List<String> year);
	
}
