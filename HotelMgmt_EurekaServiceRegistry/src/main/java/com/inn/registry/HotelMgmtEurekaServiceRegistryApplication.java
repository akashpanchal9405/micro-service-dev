package com.inn.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HotelMgmtEurekaServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelMgmtEurekaServiceRegistryApplication.class, args);
	}

}
