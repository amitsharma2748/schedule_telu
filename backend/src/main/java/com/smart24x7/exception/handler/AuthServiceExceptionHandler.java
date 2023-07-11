package com.smart24x7.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.smart24x7.bean.APIResponse;
import com.smart24x7.bean.ErrorResponse;
import com.smart24x7.common.Status;
import com.smart24x7.exception.UserNotAutharizedException;

@RestControllerAdvice
public class AuthServiceExceptionHandler {

	@ExceptionHandler(UserNotAutharizedException.class)
	public ResponseEntity<APIResponse<ErrorResponse>> handleUnAutherizedException(
			UserNotAutharizedException exception) {
		return new ResponseEntity<>(APIResponse.<ErrorResponse>builder().status(Status.FAILED.toString())
				.message(exception.getMessage()).build(), HttpStatus.UNAUTHORIZED);
	}
}
