package com.inn.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.inn.inventory.entity.Inventory;
import com.inn.inventory.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	public  CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args ->{
			Inventory inventory1 = Inventory.builder()
			.skuCode("Iphone_13")
			.quantity(100)
			.build();
			
			Inventory inventory2 = Inventory.builder()
					.skuCode("Iphone_13_red")
					.quantity(0)
					.build();
			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
		};
	}

}
