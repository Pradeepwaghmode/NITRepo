package com.nt.Repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.moduls.Movie;
import com.nt.views.ResultView;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	

	public Iterable<ResultView> findByYear(String year);
}
