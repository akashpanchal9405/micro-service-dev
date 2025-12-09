package com.inn.transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inn.transaction.entity.Order;
import com.inn.transaction.repository.OrderRepository;
import com.inn.transaction.service.OrderService;
import com.inn.transaction.service.PaymentValidatorHandler;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PaymentValidatorHandler paymentValidatorHandler;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Order saveOrder(Order order) {
		paymentValidatorHandler.validatePayment(order);
		return orderRepository.save(order);
	}

}
