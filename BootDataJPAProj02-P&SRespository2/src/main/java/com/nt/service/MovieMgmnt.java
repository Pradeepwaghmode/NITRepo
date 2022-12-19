package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.Repository.IMovieRepo;
import com.nt.moduls.Movie;

@Service
public class MovieMgmnt implements IMovieMgmtService {

	@Autowired
	public IMovieRepo repo;

	@Override
	public Iterable<Movie> displayMovieById(boolean asc, String... properties) {
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		System.out.println("MovieMgmnt.displayMovieById()");

		return repo.findAll(sort);
	}

	@Override
	public Page<Movie> generateReport(int pageNo, int pageSize, boolean asc, String... properties) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo, pageSize, asc ? Direction.ASC : Direction.DESC, properties);
		return repo.findAll(pageable);
	}

	@Override
	public void generateDetailReport(int pagesize) {

		long recordCount = repo.count();

		long pageCount = recordCount / pagesize;

		pageCount = pageCount % pagesize == 0 ? pageCount : ++pageCount;

		for (int pageno = 0; pageno < pageCount; pageno++) {
			Pageable pageable = PageRequest.of(pageno, pagesize);

			Page<Movie> page = repo.findAll(pageable);

			System.out.println("------------page No : " + pageno + " page Size : " + pagesize + " page Record count : "
					+ page.getNumberOfElements() + "-----------------");

			List<Movie> movie = page.getContent();
			movie.forEach(m -> {
				System.out.println(m);
			});
		}
	}

	@Override
	public List<Movie> SearchMovieByMlovie(Movie movie, boolean asc, String... properties) {
		// TODO Auto-generated method stub
		Example<Movie> example=Example.of(movie);
		
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC, properties);
		
		List<Movie> list=repo.findAll(example,sort);
		
		return list;
	}
	
	@Override
	public Movie searchMovieById(Integer id) {
		Movie movie=repo.getById(id);
		return movie;
	}

}
