package com.smart24x7.exception;

public class RosterDetailsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RosterDetailsNotFoundException(String msg) {
		super(msg);
	}
}
