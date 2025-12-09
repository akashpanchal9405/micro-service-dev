package com.inn.transaction.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inn.transaction.entity.AuditLog;
import com.inn.transaction.entity.Order;
import com.inn.transaction.repository.AuditLogRepository;

@Service
public class PaymentValidatorHandler {

	@Autowired
	private AuditLogRepository auditLogRepository;

	@Transactional(propagation = Propagation.MANDATORY)
	public void validatePayment(Order order) {
		// Assume payment processing happens here
		Boolean paymentSuccessful = false;
		//if payment is unsuccessful we'll log the payment failed
		if (!paymentSuccessful) {
			AuditLog paymentFailureLog = AuditLog.builder().orderId(order.getOrderId()).action(null)
					.localDateTime(LocalDateTime.now()).build();
			//save the payment failure log
			auditLogRepository.save(paymentFailureLog);
		}
	}

}
