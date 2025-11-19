package com.inn.order.controller;

import org.apache.kafka.common.Uuid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.base.dto.Order;
import com.inn.base.dto.OrderEvent;
import com.inn.order.kafka.OrderProducer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	private OrderProducer orderProducer;

	public OrderController(OrderProducer orderProducer) {
		super();
		this.orderProducer = orderProducer;
	}

	@PostMapping("/orders")
	public ResponseEntity<String> placeOrder(@RequestBody Order order) {
		order.setOrderId(Uuid.randomUuid().toString());

		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setMessage("Order status is in pending state");
		orderEvent.setStatus("Pending");
		orderEvent.setOrder(order);

		orderProducer.sendMessage(orderEvent);

		return ResponseEntity.ok("order placed successfully...");
	}

}
