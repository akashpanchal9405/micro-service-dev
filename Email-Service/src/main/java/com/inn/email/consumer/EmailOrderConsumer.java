package com.inn.email.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.inn.base.dto.OrderEvent;

@Service
public class EmailOrderConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailOrderConsumer.class);

	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumeOrder(OrderEvent orderEvent) {
		LOGGER.info(String.format("Orders consumed by email service => %s", orderEvent.toString()));

	}
	
	public static void main(String[] args) {
		
		
	}


}
