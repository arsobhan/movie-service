package com.sample.movie;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sample.movie.controller.MovieController;
import com.sample.movie.entity.Movie;
import com.sample.movie.service.MovieService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MovieController.class)
public class MovieControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MovieService movieService;
	
	
	@Test
	public void getMovie() throws Exception{
		Movie mockMovie = new Movie(1, "Movie1", "FamilyMovie");
		Mockito.when(movieService.getMovie(Mockito.anyLong()))
				.thenReturn(mockMovie);
	RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/movies/movie/1").accept(MediaType.APPLICATION_JSON);
	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	System.out.println(result.getResponse());
	String expected = "{id:1,movieName:Movie1,movieDesc:FamilyMovie}";
	JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void getAllMovies()  throws Exception{
		List<Movie> mockMovies = Arrays.asList(new Movie(1, "Movie1", "FamilyMovie"),new Movie(2, "Movie2", "KidsMovie"),new Movie(3, "Movie3", "HumourMovie"));
		Mockito.when(movieService.getAllMovies())
				.thenReturn(mockMovies);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/movies/").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		String expected = "[{id:1,movieName:Movie1,movieDesc:FamilyMovie},{id:2,movieName:Movie2,movieDesc:KidsMovie},{id:3,movieName:Movie3,movieDesc:HumourMovie}]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
	}
	
	@Test
	public void addMovie() throws Exception{
		
	}

}
