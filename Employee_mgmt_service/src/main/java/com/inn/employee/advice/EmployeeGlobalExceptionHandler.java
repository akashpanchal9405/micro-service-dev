package com.inn.employee.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inn.employee.exceptions.EmployeeNotFoundException;

@RestControllerAdvice
public class EmployeeGlobalExceptionHandler {

	@ExceptionHandler(exception = EmployeeNotFoundException.class)
	public ResponseEntity<ApiResponse> employeeHandler(String message) {

		ApiResponse response = ApiResponse.builder().status(HttpStatus.NOT_FOUND).message(message).success(true)
				.build();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
