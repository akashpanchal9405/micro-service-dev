package com.inn.merchant.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inn.merchant.exceptions.MerchantNotFoundException;
import com.inn.merchant.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class MerchantAdvice {

	@ExceptionHandler(MerchantNotFoundException.class)
	public ResponseEntity<ApiResponse> merchantNotFoundException(MerchantNotFoundException message) {
		ApiResponse apiResponse = ApiResponse.builder().message("merchant not found").success(true)
				.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ApiResponse> productNotFoundException(ProductNotFoundException message) {
		ApiResponse apiResponse = ApiResponse.builder().message("product not found").success(true)
				.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
	}
	
	
}
