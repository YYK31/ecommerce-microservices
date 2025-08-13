package com.e_commerce.product_service.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	   @ExceptionHandler(ProductNotFoundException.class)
	    public ResponseEntity<Map<String, Object>> handleProductNotFound(ProductNotFoundException ex) {
	        Map<String, Object> errorBody = new HashMap<>();
	        errorBody.put("timestamp", LocalDateTime.now());
	        errorBody.put("status", HttpStatus.NOT_FOUND.value());
	        errorBody.put("error", "Not Found");
	        errorBody.put("message", ex.getMessage());
	        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	    }

}
