package com.inn.inventory.service;

import java.util.List;

import com.inn.inventory.dto.InventoryResponse;

public interface InventoryService {
	
	public List<InventoryResponse> isInStock(List<String> skuCode);

}
