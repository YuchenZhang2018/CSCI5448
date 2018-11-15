package com.ecommerceservice.model.user;

import java.util.ArrayList;
import java.util.List;

import com.ecommerceservice.model.common.Product;




public class Cart {
	
	private List<Product> productList;
	private String id;
	
	public Cart() {
		productList = new ArrayList<Product>();
	}
	
	public double getTotalPrice() {
		double totalPrice = 0.0;
		for(Product product:productList) {
			totalPrice += product.getPrice();
		}
		return totalPrice;
	}
	
	public void addItem(Product product) {
		
	}
	
	public void deleteItem(Product product) {
		
	}
	

	public void setItemNum (int itemnum) {
		
	}
	
	
	public List<Product> getProductList(){
		return productList;
	}
	public String getId() {
		return id;
	}

}
