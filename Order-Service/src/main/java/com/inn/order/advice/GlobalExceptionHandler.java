package com.inn.order.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inn.order.exceptions.OrderNotPlacedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(OrderNotPlacedException.class)
	public ResponseEntity<ApiResponse> orderNotPlacedException(OrderNotPlacedException exception) {
		ApiResponse apiResponse = ApiResponse.builder().message(exception.getMessage()).success(true)
				.status(HttpStatus.CONFLICT).build();
		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse> globalException(Exception exception) {
		ApiResponse apiResponse = ApiResponse.builder().message(exception.getMessage()).success(true)
				.status(HttpStatus.CONFLICT).build();
		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
	}

}
