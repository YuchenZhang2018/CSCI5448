package com.ecommerceservice.model.product;

/**
 * concrete class extends ProductItem
 */
public class Paper extends ProductItem{
	public Paper() {
		categary="paper";
	}
	@Override
	String extraInfo() {	
		return "Please reserve in dry area.";
	}

}
