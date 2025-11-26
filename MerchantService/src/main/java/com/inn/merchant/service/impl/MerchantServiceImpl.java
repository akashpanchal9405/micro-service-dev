package com.inn.merchant.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.merchant.entity.Merchant;
import com.inn.merchant.exceptions.MerchantNotFoundException;
import com.inn.merchant.repository.MerchantRepository;
import com.inn.merchant.service.MerchantService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantRepository merchantRepository;

	@Override
	public Merchant addMerchantDetails(Merchant merchant) {
		log.info("inside merchant service addMerchantDetails merchant:{}", merchant);
		Merchant updatedMerchant = null;
		if (merchant != null) {
			updatedMerchant = merchantRepository.save(merchant);
			log.info("inside merchant service addMerchantDetails merchant:{}", merchant);
		}
		return updatedMerchant;
	}

	@Override
	public Merchant getMerchantDetails(Integer merchantId) {
		log.info("inside merchant service getMerchantDetails merchantId");
		Optional<Merchant> dbRecord = null;
		Merchant merchant = null;
		if (merchantId != null) {
			dbRecord = Optional.ofNullable(merchantRepository.findById(merchantId)
					.orElseThrow(() -> new MerchantNotFoundException(merchantId)));
		}
		return dbRecord.isPresent() ? dbRecord.get() : merchant;
	}

}
