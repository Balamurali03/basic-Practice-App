package com.example.practice.practice_app.Exception;

public class NoValidDataException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public NoValidDataException(String message) {
		super("The given data is not a valid one");
	}
}
