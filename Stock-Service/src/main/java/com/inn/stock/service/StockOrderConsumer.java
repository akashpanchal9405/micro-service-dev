package com.inn.stock.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.inn.base.dto.OrderEvent;

@Service
public class StockOrderConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(StockOrderConsumer.class);

	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumeOrderEvent(OrderEvent orderEvent) {
		LOGGER.info(String.format("order message consumed by stock service => %s", orderEvent.toString()));
	}

}
