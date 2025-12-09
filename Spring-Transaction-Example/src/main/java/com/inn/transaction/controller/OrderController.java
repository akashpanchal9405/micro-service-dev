package com.inn.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.transaction.entity.Order;
import com.inn.transaction.service.OrderProcessingHandler;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderProcessingHandler orderProcessingHandler;

	@PostMapping
	public ResponseEntity<?> placeOrder(@RequestBody Order order) {
		return ResponseEntity.ok(orderProcessingHandler.processOrder(order));
	}

}
