package com.inn.hotel.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inn.hotel.exceptions.HotelNotFoundException;

@RestControllerAdvice
public class HotelAdvice {

	@ExceptionHandler(value = HotelNotFoundException.class)
	public ResponseEntity<HotelApiResponse> hotelNotFoundException(HotelNotFoundException ex) {
		return new ResponseEntity<>(
				HotelApiResponse.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build(),
				HttpStatus.NOT_FOUND);
	}

}
