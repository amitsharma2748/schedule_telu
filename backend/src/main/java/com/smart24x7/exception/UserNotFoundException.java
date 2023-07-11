package com.smart24x7.exception;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 9076819831826991503L;

	public UserNotFoundException(String msg) {
		super(msg);
	}
}
