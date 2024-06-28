package com.example.practice.practice_app.ControllerExceptionHandler;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.practice.practice_app.Exception.DataNotStoredException;
import com.example.practice.practice_app.Exception.NoDataFoundException;
import com.example.practice.practice_app.Exception.NoValidDataException;
import com.example.practice.practice_app.Exception.UserAlreadyExistException;
import com.example.practice.practice_app.Exception.UserNotFoundException;
import com.example.practice.practice_app.Response.ErrorResponse;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(value = DataNotStoredException.class)
	public ResponseEntity<ErrorResponse> handleDataNotStoredException(DataNotStoredException ex) {
		log.info("Entered into the GlobalExceptionHandler ControllerAdvice class ==> \n"
				+ " handleDataNotStoredException method");
		ErrorResponse errorResponse = new ErrorResponse(LocalTime.now(), HttpStatus.BAD_GATEWAY.value(),
				ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(502));
	}

	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ErrorResponse> handleNoDataFoundException(NoDataFoundException ex) {
		log.info("Entered into the GlobalExceptionHandler ControllerAdvice class ==> \n"
				+ " handleNoDataFoundException method");
		ErrorResponse errorResponse = new ErrorResponse(LocalTime.now(), HttpStatus.NOT_FOUND.value(),
				ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatusCode.valueOf(404));
	}

	@ExceptionHandler(value = NoValidDataException.class)
	public ResponseEntity<ErrorResponse> handleNoValidDataException(NoValidDataException ex) {
		log.info("Entered into the GlobalExceptionHandler ControllerAdvice class ==> \n"
				+ " handleNoValidDataException method");
		ErrorResponse errorResponse = new ErrorResponse(LocalTime.now(), HttpStatus.BAD_REQUEST.value(),
				ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(400));
	}

	@ExceptionHandler(value = UserAlreadyExistException.class)
	public ResponseEntity<ErrorResponse> handleUserAlreadyExistException(UserAlreadyExistException ex) {
		log.info("Entered into the GlobalExceptionHandler ControllerAdvice class ==> \n"
				+ " handleUserAlreadyExistException method");
		ErrorResponse errorResponse = new ErrorResponse(LocalTime.now(), HttpStatus.NOT_ACCEPTABLE.value(),
				ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(406));
	}

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
		log.info("Entered into the GlobalExceptionHandler ControllerAdvice class ==> \n"
				+ " handleUserNotFoundException method");
		ErrorResponse errorResponse = new ErrorResponse(LocalTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(404));
	}

}
