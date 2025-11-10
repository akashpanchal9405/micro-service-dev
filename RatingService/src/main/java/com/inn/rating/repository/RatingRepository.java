package com.inn.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.rating.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

	public List<Rating> findRatingByUserId(Integer userId);

	public List<Rating> findRatingByHotelId(Integer hotelId);
}
