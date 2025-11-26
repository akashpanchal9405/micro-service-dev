package com.inn.merchant.exceptions;

public class MerchantNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MerchantNotFoundException() {
		super("merchant with merchantId not found!!!");
	}

	public MerchantNotFoundException(Integer merchantId) {
		super("merchant with merchantId not found merchantId:{}" + merchantId);
	}

}
