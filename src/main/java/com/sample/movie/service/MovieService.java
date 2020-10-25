package com.sample.movie.service;

import java.util.List;

import com.sample.movie.entity.Movie;

public interface MovieService{
	
	public abstract void addMovie(String movieName, String movieDesc);
	public abstract Movie getMovie(Long id);
	public abstract List<Movie> getAllMovies();

}
