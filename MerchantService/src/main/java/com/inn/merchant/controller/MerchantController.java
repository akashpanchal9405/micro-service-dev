package com.inn.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.merchant.entity.Merchant;
import com.inn.merchant.service.MerchantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

	@Autowired
	private MerchantService merchantService;

	@PostMapping("/addMerchant")
	public ResponseEntity<Merchant> addMerchantDetails(@Valid @RequestBody Merchant merchant) {
		return ResponseEntity.status(HttpStatus.CREATED).body(merchantService.addMerchantDetails(merchant));
	}

	@GetMapping("/getMerchant/{merchantId}")
	public ResponseEntity<Merchant> getMerchantDetails(@PathVariable Integer merchantId) {
		return ResponseEntity.ok(merchantService.getMerchantDetails(merchantId));
	}

}
