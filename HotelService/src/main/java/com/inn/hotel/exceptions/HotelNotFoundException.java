package com.inn.hotel.exceptions;

public class HotelNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HotelNotFoundException() {
		super("Hotel with given hotelId not found!!!");
	}

	public HotelNotFoundException(Integer hotelId) {
		super("Hotel with given hotelId not found!!!" + hotelId);
	}

}
