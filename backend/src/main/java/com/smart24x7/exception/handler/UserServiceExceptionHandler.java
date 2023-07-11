package com.smart24x7.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.smart24x7.common.Status;
import com.smart24x7.exception.ExceptionResponse;
import com.smart24x7.exception.RosterDetailsNotFoundException;

@RestControllerAdvice
public class UserServiceExceptionHandler {

	@ExceptionHandler(RosterDetailsNotFoundException.class)
	public ResponseEntity<ExceptionResponse<?>> handleRosterDetailsException(
			RosterDetailsNotFoundException exception) {
		return new ResponseEntity<>(ExceptionResponse.builder().status(Status.FAILED.toString())
				.message(exception.getMessage()).build(), HttpStatus.NO_CONTENT);
	}
}
