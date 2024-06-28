package com.example.practice.practice_app.Exception;

public class UserAlreadyExistException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	public UserAlreadyExistException(String message) {
		super(message);
	}

}
