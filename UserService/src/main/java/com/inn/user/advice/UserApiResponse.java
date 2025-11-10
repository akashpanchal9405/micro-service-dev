package com.inn.user.advice;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserApiResponse {

	private String message;

	private Boolean success;

	private HttpStatus status;


}
