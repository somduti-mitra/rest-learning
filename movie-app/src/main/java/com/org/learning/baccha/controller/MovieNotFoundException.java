package com.org.learning.baccha.controller;

public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MovieNotFoundException(String movieName) {
		super(movieName);

	}

}
