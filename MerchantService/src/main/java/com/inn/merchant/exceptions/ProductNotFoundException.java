package com.inn.merchant.exceptions;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
		super("product not found with given productId!!!");
	}

	public ProductNotFoundException(Integer productId) {
		super("product not found with given productId:"+productId);
	}

}
