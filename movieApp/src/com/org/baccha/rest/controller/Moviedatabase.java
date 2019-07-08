package com.org.baccha.rest.controller;

import java.util.ArrayList;
import java.util.List;

public class Moviedatabase {

	private static List<Movie> movielist = new ArrayList<Movie>();
	static {
		movielist.add(new Movie("Titanic", "Drama", 1));
		movielist.add(new Movie("Gladiator", "History", 2));
		movielist.add(new Movie("Kota Factory", "Horror", 6));
		movielist.add(new Movie("Kabeer Singh", "Romantic", 3));
		movielist.add(new Movie("Kabir Singh", "History", 9));
		movielist.add(new Movie("Somduti", "Biopic", 10));
		movielist.add(new Movie("Sanjay", "Biopic", 8));
		movielist.add(new Movie("Accenture", "Thriller", 4));
	}

	public static List<Movie> getMovielist() {
		return movielist;
	}

	public static void setMovielist(List<Movie> movielist) {
		Moviedatabase.movielist = movielist;
	}
}
