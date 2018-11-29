package com.ecommerceservice.model.product;

/**
 * concrete class extends ProductItem
 */
public class Food extends ProductItem{
	
	public Food() {
		categary = "food";
	}

	@Override
	String extraInfo() {
		return "please reserve in reftigerator";	
	}

}
