package com.org.baccha.rest.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/app")
public class MovieController {

	MovieService movieService = new MovieService();

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Movie> doing() {
		return movieService.getMovielist();
	}

	@GET
	@Path("by-name/{name}")
	@Produces(MediaType.APPLICATION_XML)
	public Movie getMovieName(@PathParam("name") String movieName) {
		return movieService.search(movieName);
	}

	@GET
	@Path("/by-id/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Movie getMovieID(@PathParam("id") int movieId) {
		return movieService.search(movieId);
	}

	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Object addMovie(Movie movie) {
		return movieService.addMovie(movie);
	}

	@DELETE
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })

	public Object deleteMovie(Movie movie) {
		return movieService.deleteMovie(movie);
	}

	@GET
	@Path("/genrestarts")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Object retrieveMovie(@QueryParam("genre") char genre) {
		return movieService.retrieve(genre);
	}
	
	@GET
	@Path("/withalphabet")
	@Produces({MediaType.APPLICATION_JSON })
	public Object retrieveNames(@QueryParam("movieCharacter")char movieName, @QueryParam("genretype")char genre) {
		return movieService.retrieval(movieName, genre);
	}
	
	@GET
	@Path("/sort")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Movie> comparing() {
		return movieService.defaultSort();
		
	}
	@GET
	@Path("/sortonid")
	@Produces(MediaType.APPLICATION_XML)
	public List<Movie> comparingonId(){
		return movieService.sortonid();
		
	}
	
}
