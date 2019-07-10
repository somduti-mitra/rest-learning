package com.org.learning.baccha.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Date;
import java.util.List;

public class MovieService {

	// get all movie
	public List<Movie> getMovielist() {
		return Moviedatabase.getMovielist();
	}

	// Search by name
	// throwing Exception
	public Movie search(String movieName) {
		Movie movie = null;
		for (Movie m : Moviedatabase.getMovielist()) {
			if (m.getMovieName().equalsIgnoreCase(movieName)) {
				movie = m;
			}
		}
		if (movie == null) {
			throw new MovieNotFoundException("Movie with name" + movieName + "not found");
		}
		return movie;

	}

	// search by id
	public Movie search(int movieId) {
		for (Movie m : Moviedatabase.getMovielist()) {
			if (m.getMovieId() == movieId) {
				return m;
			}
		}
		return null;
	}

	// add movie
	public Object addMovie(Movie movie) {
		// for(TypeOFObject currentObject: List)
		List<Movie> movLst = Moviedatabase.getMovielist();
		for (Movie movie1 : movLst) {
			if (movie1.getMovieName().equalsIgnoreCase(movie.getMovieName())) {
				return "this already exists";
			}
		}
		Moviedatabase.getMovielist().add(movie);
		return "Movie added";
	}

	// Delete movie
	public Object deleteMovie(Movie movie) {
		List<Movie> movieLst = Moviedatabase.getMovielist();
		for (Movie movie1 : movieLst) {
			if (movie1.getMovieName().equalsIgnoreCase(movie.getMovieName())) {
				return Moviedatabase.getMovielist().remove(movie);
			}
		}
		return "This does not exist";
	}

	// Retrieve based on genre of a particular alphabet

	public List<Movie> retrieve(char genre) {
		List<Movie> genreList = new ArrayList<>();
		List<Movie> movie2 = Moviedatabase.getMovielist();
		for (Movie movieretrieval : movie2) {
			if (movieretrieval.getGenre().charAt(0) == genre) {
				genreList.add(movieretrieval);
			}
		}
		return genreList;
	}

	// group alphabetically

	public List<Movie> defaultSort() {
		List<Movie> sortingList = Moviedatabase.getMovielist();
		Collections.sort(sortingList, Collections.reverseOrder());
		return sortingList;
	}
	// Retrieve based on movieid

	public List<Movie> sortonid() {
		List<Movie> sortbasedonid = Moviedatabase.getMovielist();
		Collections.sort(sortbasedonid, new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				if (o1.getMovieId() > o2.getMovieId())
					return -1;
				else if (o1.getMovieId() < o2.getMovieId())
					return 1;
				else
					return 0;
			}
		});
		return sortbasedonid;
	}

	// Retrieve based on a starting alphabet and staring alphabet of genre

	public List<Movie> retrieval(char movieName, char genre) {
		List<Movie> particularAlphabet = new ArrayList<>();
		List<Movie> movie3 = Moviedatabase.getMovielist();
		for (Movie movieretrieving : movie3) {
			if (movieretrieving.getMovieName().charAt(0) == movieName
					&& movieretrieving.getGenre().charAt(0) == genre) {
				particularAlphabet.add(movieretrieving);
			}
		}
		return particularAlphabet;
	}

	// group by id, name& genre

	/*
	 * public static void main(String[] args) { MovieService movie2 = new
	 * MovieService(); System.out.println(movie2.addMovie(new
	 * Movie("yoyo","History",2))); }
	 */

}
