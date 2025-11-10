package com.inn.hotel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.hotel.dto.HotelDTO;
import com.inn.hotel.entity.Hotel;
import com.inn.hotel.repository.HotelRepository;
import com.inn.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel addHotel(HotelDTO hotelDTO) {
		Hotel hotel = null;
		if (hotelDTO != null) {
			hotel = new Hotel();
			BeanUtils.copyProperties(hotelDTO, hotel);
			hotel = hotelRepository.save(hotel);
		}
		return hotel;
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(Integer hotelId) {
		Optional<Hotel> dbRecord = null;
		Hotel hotel = null;
		if (hotelId != null) {
			dbRecord = hotelRepository.findById(hotelId);
		}
		return dbRecord.isPresent() ? dbRecord.get() : hotel;
	}

}
