package com.spring.movie.repo;
	import org.springframework.data.jpa.repository.JpaRepository;

	import com.spring.movie.entity.Movie;

	public interface MovieRepo extends JpaRepository<Movie, Integer>
	{
		

	}

