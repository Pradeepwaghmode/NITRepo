package com.nt.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.nt.moduls.Movie;

public interface IMovieRepo extends CrudRepository<Movie, Integer>,PagingAndSortingRepository<Movie, Integer>,JpaRepository<Movie, Integer> {
	

}
