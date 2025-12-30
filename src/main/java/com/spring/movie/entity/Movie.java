package com.spring.movie.entity;



	//import org.springframework.data.annotation.Id;

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import lombok.Data;

	@Entity
	@Data
	public class Movie {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY strategy doesn’t reuse deleted IDs
		private int movieId;
		private String movieName;
		private String language;
		private double rating;
		private String genre;

	}

