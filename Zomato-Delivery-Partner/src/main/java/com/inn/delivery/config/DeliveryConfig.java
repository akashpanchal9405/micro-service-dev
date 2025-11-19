package com.inn.delivery.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.inn.delivery.constants.AppConstants;

@Configuration
public class DeliveryConfig {

	@Bean
	public NewTopic createNewTopic() {
		return TopicBuilder.name(AppConstants.LOCAION_UPDATE_TOPIC)
//				.partitions(1) //to create partitions in topic
//				.replicas(1) // to create replicas of partitions
				.build();
	}

}
