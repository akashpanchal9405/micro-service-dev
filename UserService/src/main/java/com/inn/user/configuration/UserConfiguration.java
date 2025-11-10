package com.inn.user.configuration;

import org.springframework.web.client.RestTemplate;

//@Configuration
public class UserConfiguration {

//	@Bean
//	@LoadBalanced
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
