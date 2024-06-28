package com.example.practice.practice_app.Response;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

	private LocalTime timestamp;
	private Integer status;
	private String message;

}
