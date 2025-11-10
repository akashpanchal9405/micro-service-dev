package com.inn.hotel.service;

import java.util.List;

import com.inn.hotel.dto.HotelDTO;
import com.inn.hotel.entity.Hotel;

public interface HotelService {
	
	public Hotel addHotel(HotelDTO hotelDTO);
	
	public List<Hotel> getAllHotels();
	
	public Hotel getHotelById(Integer hotelId);

}
