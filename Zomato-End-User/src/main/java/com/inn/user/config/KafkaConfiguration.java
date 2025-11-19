package com.inn.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.inn.user.constants.KafkaConstants;

@Configuration
public class KafkaConfiguration {

	@KafkaListener(topics = KafkaConstants.LOCATION_UPDATE_TOPIC, groupId = KafkaConstants.GROUP_ID)
	public void consumeUpdatedLocation(String value) {
		System.out.println(value);
	}

}
