package com.spring.movie.service;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.spring.movie.entity.Movie;
	import com.spring.movie.repo.MovieRepo;

	@Service
	public class MovieServiceImpl implements MovieService {
		
		@Autowired
		MovieRepo mrepo;
		@Override
		public void saveMovie(Movie movie) {
			if(movie!=null) 
			{
				mrepo.save(movie);
			}
			
			
		}

	    @Override
	    public List<Movie> getAllMovies() {
	        return mrepo.findAll();
	    }
	   @Override
		public void deleteMovieById(int id) {
			
				mrepo.deleteById(id);
			
	    }
	   @Override
	   public Movie getMovieById(int id) {
	       return mrepo.findById(id).orElse(null);
	   }

		

	}
	


