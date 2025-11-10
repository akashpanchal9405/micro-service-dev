package com.inn.user.advice;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super("User not found on server!!!");
	}

	public UserNotFoundException(String message) {
		super(message);
	}

}
