package com.inn.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.rating.dto.RatingDTO;
import com.inn.rating.entity.Rating;
import com.inn.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PostMapping("/addRating")
	public ResponseEntity<Rating> addRating(@RequestBody RatingDTO ratingDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.addRating(ratingDto));
	}

	@GetMapping("/getAllRatings")
	public ResponseEntity<List<Rating>> getAllRatings() {
		return ResponseEntity.ok(ratingService.getAllRatings());
	}

	@GetMapping("/getRatingByUserId/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable Integer userId) {
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	}

	@GetMapping("/getRatingByHotelId/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable Integer hotelId) {
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
	}

	@PutMapping("/updateRating/{ratingId}")
	public ResponseEntity<Rating> updateRating(@PathVariable Integer ratingId, @RequestBody Rating rating) {
		return ResponseEntity.ok(ratingService.updateRating(ratingId, rating));
	}

}
