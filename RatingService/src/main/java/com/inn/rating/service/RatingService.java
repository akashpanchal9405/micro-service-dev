package com.inn.rating.service;

import java.util.List;

import com.inn.rating.dto.RatingDTO;
import com.inn.rating.entity.Rating;

public interface RatingService {

	public Rating addRating(RatingDTO ratingDto);

	public List<Rating> getAllRatings();

	public List<Rating> getRatingByUserId(Integer userId);

	public List<Rating> getRatingByHotelId(Integer hotelId);

	public Rating updateRating(Integer ratingId, Rating rating);

	public String deleteRating(Integer ratingId);

}
