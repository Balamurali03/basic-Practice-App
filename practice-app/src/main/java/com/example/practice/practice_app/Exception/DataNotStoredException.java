package com.example.practice.practice_app.Exception;

public class DataNotStoredException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataNotStoredException(String message) {
		super(message);
	}
}
