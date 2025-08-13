package com.e_commerce.product_service.exception;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException(String msg) {
		super(msg);
	}
}
