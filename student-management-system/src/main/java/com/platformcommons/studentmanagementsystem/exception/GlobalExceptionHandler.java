package com.platformcommons.studentmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
		System.out.println("GLOBAL HANDLER CALLED: " + ex.getMessage());
		String message = ex.getMessage();

		if (message == null || message.isEmpty()) {
			message = "Student not found";
		}
		ErrorResponse errorResponse = new ErrorResponse(message, HttpStatus.NOT_FOUND.value());
		System.out.println("MESSAGE: " + errorResponse.getMessage());
		System.out.println("STATUS: " + errorResponse.getStatus());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
}
