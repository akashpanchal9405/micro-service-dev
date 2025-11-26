package com.inn.merchant.service;

import com.inn.merchant.entity.Merchant;

public interface MerchantService {
	
	public Merchant addMerchantDetails(Merchant merchant);
	
	public Merchant getMerchantDetails(Integer merchantId);

}
