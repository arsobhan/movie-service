package com.sample.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	
	
	@Id
	@GeneratedValue
	@Column(name = "movie_id")
	private long id;
	
	@Column(name = "movie_name")
	private String movieName;
	
	@Column(name = "movie_desc")
	private String movieDesc;
	
	

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(long id, String movieName, String movieDesc) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieDesc = movieDesc;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDesc() {
		return movieDesc;
	}

	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}
	

}
