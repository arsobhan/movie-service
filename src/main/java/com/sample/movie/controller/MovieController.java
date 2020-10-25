package com.sample.movie.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.movie.entity.Movie;
import com.sample.movie.model.MovieObj;
import com.sample.movie.service.MovieService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RequestMapping("/movies")
@RestController
@Api(consumes="application/json", produces="application/json")
public class MovieController {
	
	private static final Logger logger= LoggerFactory.getLogger(MovieController.class);
	
@Autowired
MovieService movieService;
	
@GetMapping("/movie/{movieId}")
@ApiOperation(value="Finds Movie by id", notes = "This call retrieves a movie given the movie id.", tags={"Movie"}, httpMethod="GET")
public ResponseEntity<Movie> getMovie(@ApiParam(value = "ID of movie to return", required=true) @PathVariable("movieId") Long id) {
	logger.info("Fetching movie details based in ID");
	return new ResponseEntity<>(movieService.getMovie(id), HttpStatus.OK);	
}

@GetMapping("/")
@ApiOperation(value="Finds all movie details", notes = "This call retreives all movies", tags={"Movie"}, httpMethod="GET")
public ResponseEntity<List<Movie>> getAllMovies() {
	logger.info("Fetching all movie details");
	return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);	
}

@PostMapping("/movie")
@ApiOperation(value="Add a new movie details", notes = "This call adds a movie", tags={"Movie"}, httpMethod="POST")
public ResponseEntity<String> addMovie(@RequestBody MovieObj movie){
	logger.info("Adding a movie");
	movieService.addMovie(movie.getMovieName(), movie.getMovieDesc());
	return new ResponseEntity<>("Movie is created added", HttpStatus.CREATED);
}
}
