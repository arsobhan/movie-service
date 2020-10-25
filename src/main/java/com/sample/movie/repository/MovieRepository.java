package com.sample.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sample.movie.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	@Query("SELECT m FROM Movie m WHERE m.id = ?1")
	Movie findByMovieId(Long id);

}
