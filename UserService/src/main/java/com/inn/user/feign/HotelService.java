package com.inn.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.inn.user.hotel.Hotel;

@FeignClient(name = "HOTEL-SERVICE/hotel")
public interface HotelService {

	@GetMapping("/getHotelById/{hotelId}")
	public Hotel getHotelById(@PathVariable Integer hotelId);
}
