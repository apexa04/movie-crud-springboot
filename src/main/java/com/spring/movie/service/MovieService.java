package com.spring.movie.service;
	import java.util.List;

	import com.spring.movie.entity.Movie;

	public interface MovieService {
		
		
		void saveMovie(Movie movie);
		List<Movie> getAllMovies();
		void deleteMovieById(int id);
		Movie getMovieById(int id);


	}

