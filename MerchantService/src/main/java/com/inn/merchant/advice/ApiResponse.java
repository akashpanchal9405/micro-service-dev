package com.inn.merchant.advice;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {

	private String message;

	private Boolean success;

	private HttpStatus status;

}
