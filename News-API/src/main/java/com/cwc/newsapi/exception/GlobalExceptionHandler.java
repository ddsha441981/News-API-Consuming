package com.cwc.newsapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ApiKeyMissing.class)
	public ResponseEntity<ApiResponse> handleAPIKEYMissing(ApiKeyMissing keyMissing){
		ApiResponse response = new ApiResponse();
		response.setCode(keyMissing.getLocalizedMessage());
		response.setMessage(keyMissing.getMessage());
		response.setStatus(keyMissing.toString());
		return new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);
	}
}
