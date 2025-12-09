package com.inn.transaction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inn.transaction.entity.Order;

@Service
public class NotificationHandler {
	
	@Transactional(propagation = Propagation.NEVER)
	public void sendOrderConfirmationNotification(Order order) {
		//send an email notification to user
		System.out.println(order.getOrderId() +" Order placed successfully");
	}

}
