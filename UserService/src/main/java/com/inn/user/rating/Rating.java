package com.inn.user.rating;

import com.inn.user.hotel.Hotel;

import lombok.Data;

@Data
public class Rating {

	private Integer ratingId;

	private Integer userId;

	private Integer hotelId;

	private String rating;

	private String feedback;

	private Hotel hotel;

}
