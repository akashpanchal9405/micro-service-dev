package com.inn.rating.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class RatingDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ratingId;

	private Integer userId;

	private Integer hotelId;

	private Integer rating;

	private String feedback;

}
