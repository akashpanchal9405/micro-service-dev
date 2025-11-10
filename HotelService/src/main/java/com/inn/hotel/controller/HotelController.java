package com.inn.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.hotel.dto.HotelDTO;
import com.inn.hotel.entity.Hotel;
import com.inn.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@PostMapping("/addHotelDetails")
	public ResponseEntity<Hotel> addHotelDetails(@RequestBody HotelDTO hotelDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.addHotel(hotelDTO));
	}

	@GetMapping("/getAllHotels")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		return ResponseEntity.ok(hotelService.getAllHotels());
	}

	@GetMapping("/getHotelById/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable Integer hotelId) {
		return ResponseEntity.ok(hotelService.getHotelById(hotelId));
	}
}
