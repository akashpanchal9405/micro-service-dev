package com.inn.user.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserAdvice {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<UserApiResponse> userNotFound(UserNotFoundException userNotFoundException) {
		System.out.println("we are in global exception handler");
		return new ResponseEntity<>(UserApiResponse.builder().message(userNotFoundException.getMessage()).success(true)
				.status(HttpStatus.NOT_FOUND).build(), HttpStatus.NOT_FOUND);
	}

}
