package com.spring.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.movie.entity.Movie;
import com.spring.movie.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieService mservice;

	@GetMapping("/")
	//@RequestMapping(path="/")
	public String home() {
		return "Index";
	}

	@GetMapping("/add")
	public String addMovieFrom() {
		return "AddMovie";
	}

	@PostMapping("/save")
	public String saveMovie(@ModelAttribute Movie movie) {
		mservice.saveMovie(movie);
		return "redirect:/movie/view";
	}

	//	    @GetMapping("/view")
	//	    public String viewAllMovies(Model model) {
	//	        List<Movie> movielist = mservice.getAllMovies();
	//	        model.addAttribute("movies", movielist);
	//
	//	        return "AllMovies";  
	//	    }
	@GetMapping("/view")
	public String viewAllMovies(Model model) {
		List<Movie> movielist=mservice.getAllMovies();
		model.addAttribute("movies",movielist);
		return "AllMovies";
	}

	@GetMapping("/delete/{id}")
	public String deleteMovie(@PathVariable int id) {
		mservice.deleteMovieById(id);
		return "redirect:/movie/view";//redirect to particular handler
	}
	@GetMapping("/edit/{id}")
	public String editMovie(@PathVariable int id, Model model) {
		Movie existingmovie = mservice.getMovieById(id);
		model.addAttribute("movie",existingmovie);
		return "EditMovie";
	}
	//	    @PostMapping("/update")
	//	    public String updateMovie(@ModelAttribute Movie movie) {
	//	        mservice.saveMovie(movie);
	//	        return "redirect:/view";
	//	    }

	@GetMapping("/view-movie")
	public String getMovie(@RequestParam("movieId") int mid,RedirectAttributes model)
	{
		Movie movie=mservice.getMovieById(mid);
		if(movie!=null)

			model.addFlashAttribute("movie",movie);
		else
			model.addFlashAttribute("error","Movie not Found with Id:"+mid);
		return "redirect:/";
	}

}

