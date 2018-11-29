package com.ecommerceservice.model.product;

/**
 * concrete class extends ProductItem
 */
public class Toy extends ProductItem{

	public Toy() {
		categary="toy";
	}
	@Override
	String extraInfo() {
		
		return "None.";
	}

}
