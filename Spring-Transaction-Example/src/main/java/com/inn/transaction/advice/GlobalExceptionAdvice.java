package com.inn.transaction.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse> genericExceptionHander(Exception ex) {
		ApiResponse apiResponse = ApiResponse.builder().message(ex.getMessage())
				.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
	}

}
