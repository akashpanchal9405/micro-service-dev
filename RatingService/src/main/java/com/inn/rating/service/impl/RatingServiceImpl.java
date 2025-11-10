package com.inn.rating.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.rating.dto.RatingDTO;
import com.inn.rating.entity.Rating;
import com.inn.rating.repository.RatingRepository;
import com.inn.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating addRating(RatingDTO ratingDto) {
		Rating rating = null;
		if (ratingDto != null) {
			rating = new Rating();
			BeanUtils.copyProperties(ratingDto, rating);
			if (rating != null)
				rating = ratingRepository.save(rating);
		}
		return rating;
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(Integer userId) {
		return ratingRepository.findRatingByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(Integer hotelId) {
		return ratingRepository.findRatingByHotelId(hotelId);
	}

	@Override
	public Rating updateRating(Integer ratingId, Rating rating) {
		Optional<Rating> existingRating = ratingRepository.findById(ratingId);
		Rating updatedRating = null;
		if (existingRating.isPresent()) {
			updatedRating = ratingRepository.save(rating);
		}
		return updatedRating;
	}

	@Override
	public String deleteRating(Integer ratingId) {
		ratingRepository.deleteById(ratingId);
		Optional<Rating> existingRating = ratingRepository.findById(ratingId);
		StringBuilder response = new StringBuilder();
		if (existingRating.isPresent()) {
			response.append("record not deleted with ratingId:" + ratingId);
		} else
			response.append("record delete ratingId:" + ratingId);
		return response.toString();
	}

}
