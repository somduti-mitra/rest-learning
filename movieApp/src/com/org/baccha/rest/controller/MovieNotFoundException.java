package com.org.baccha.rest.controller;

public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MovieNotFoundException(String movieName) {
		super(movieName);

	}

}
