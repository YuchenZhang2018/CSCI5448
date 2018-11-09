package com.zhang.ecommerce.user;

import java.util.ArrayList;
import java.util.List;

import com.zhang.ecommerce.Product;


public class Cart {
	private int itemNum;
	private List<Product> productList;
	
	public Cart() {
		itemNum=0;
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
		if(productList.add(product)) {
			itemNum+=1;
		}
	}
	
	public void deleteItem(Product product) {
		if(productList.remove(product)) {
			itemNum-=1;
		}
	}
	

	public int getItemNum() {
		return itemNum;
	}
	
	public List<Product> getProductList(){
		return productList;
	}

}
