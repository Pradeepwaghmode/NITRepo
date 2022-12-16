package com.nt.Repository;

import org.springframework.data.repository.CrudRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.nt.moduls.Movie;

public interface IMovieRepo extends CrudRepository<Movie, ID> {
	

}
