package com.ecommerceservice.model.user;

import java.util.ArrayList;
import java.util.List;

import com.ecommerceservice.model.common.Product;
import com.ecommerceservice.model.common.Storage;




public class Cart {
	
	private List<Storage> storageList;
	private String id;
	
	public Cart() {
		storageList = new ArrayList<Storage>();
	}
	
	public double getTotalPrice() {
		double totalPrice = 0.0;
		for(Storage product:storageList) {
			totalPrice += product.getPrice();
		}
		return totalPrice;
	}
	
	public void addItem(Storage storage) {
		storageList.add(storage);
	}
	
	public void deleteItem(Storage storage) {
		storageList.remove(storage);
	}
	
	
	public List<Storage> getStorageList() {
		return storageList;
	}

	public String getId() {
		return id;
	}

}
