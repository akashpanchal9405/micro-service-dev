package com.inn.transaction.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inn.transaction.entity.Product;

@Service
public class ProductRecommendationHandler {

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Product> getRecommendations() {
		List<Product> recommendationList = new ArrayList<>();
		recommendationList.add(new Product(101, "Wireless Headphones", 999.99, 15));
		recommendationList.add(new Product(102, "SmartPhone Case", 500.99, 30));
		recommendationList.add(new Product(103, "Bluethooth Speaker", 1249.99, 25));
		recommendationList.add(new Product(104, "Gaming Mouse", 1400.99, 20));
		System.out.println("Recommendations are fetch for user...");
		return recommendationList;
	}

}
