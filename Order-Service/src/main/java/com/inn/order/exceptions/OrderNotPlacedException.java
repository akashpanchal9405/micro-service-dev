package com.inn.order.exceptions;

public class OrderNotPlacedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public OrderNotPlacedException() {
		super("");
	}
	
	public OrderNotPlacedException(String message) {
		super(message);
	}

}
