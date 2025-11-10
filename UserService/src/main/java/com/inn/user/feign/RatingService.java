package com.inn.user.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.inn.user.rating.Rating;

@FeignClient(name = "RATING-SERVICE/rating")
public interface RatingService {

	@GetMapping("/getRatingByUserId/{userId}")
	public List<Rating> getRatingsByUserId(@PathVariable Integer userId);

	@PostMapping("/addRating")
	public Rating addRating(Rating rating);

	@PutMapping("/updateRating/{ratingId}")
	public Rating updateRating(@PathVariable Integer ratingId, Rating rating);

	@DeleteMapping("/deleteRating/{ratingId}")
	public String deleteRating(@PathVariable Integer ratingId);
}
