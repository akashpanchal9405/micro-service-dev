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
public class AuditLogHandler {

	@Autowired
	private AuditLogRepository auditLogRepository;

	// this method runs in separate or independent transaction
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void logAuditDetails(Order order, String action) {
		AuditLog auditLog = AuditLog.builder().orderId(order.getOrderId()).action(action)
				.localDateTime(LocalDateTime.now()).build();
		auditLogRepository.save(auditLog);
	}

}
