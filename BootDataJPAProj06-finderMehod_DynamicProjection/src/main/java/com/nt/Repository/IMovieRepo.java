package com.nt.Repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.moduls.Movie;
import com.nt.views.Views;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	

	public <T extends Views> Iterable<T> findByYear(String year,Class<T> clazz);
}
