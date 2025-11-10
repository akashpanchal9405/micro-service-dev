package com.inn.hotel.advice;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelApiResponse {

	private String message;

	private Boolean success;

	private HttpStatus status;

}
