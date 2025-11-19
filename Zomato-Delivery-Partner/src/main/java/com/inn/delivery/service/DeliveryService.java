package com.inn.delivery.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.inn.delivery.constants.AppConstants;

@Service
public class DeliveryService {

	private Logger log = LoggerFactory.getLogger(DeliveryService.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	// single request 1 time message published
	/*
	 * public boolean locationUpdate(String location) {
	 * kafkaTemplate.send(AppConstants.LOCAION_UPDATE_TOPIC, location);
	 * log.info("location published..."); return true; }
	 */

	
	// single request 1000 time message published
	public boolean locationUpdate(String location) {
		for (int i = 1; i <= 1000; i++) {
			kafkaTemplate.send(AppConstants.LOCAION_UPDATE_TOPIC, location);
			log.info("location published count:{}",i);
			System.out.println("--------------------------------");
		}
		return true;
	}

}
