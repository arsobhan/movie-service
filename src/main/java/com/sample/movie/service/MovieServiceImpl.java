package com.sample.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.movie.entity.Movie;
import com.sample.movie.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	MovieRepository movieRepository;

	@Override
	public void addMovie(String movieName, String movieDesc) {
		Movie movie = new Movie();
		movie.setMovieName(movieName);
		movie.setMovieDesc(movieDesc);
		movieRepository.save(movie);
	}

	@Override
	public Movie getMovie(Long id) {
		return movieRepository.findByMovieId(id);
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = movieRepository.findAll();
		return movies;
	}
	

}
