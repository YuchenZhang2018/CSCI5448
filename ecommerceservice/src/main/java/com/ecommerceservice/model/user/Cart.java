package com.ecommerceservice.model.user;

import java.util.ArrayList;
import java.util.List;

import com.ecommerceservice.model.common.Storage;




public class Cart {
	
	private List<Storage> storageList;
	private String storageListStr;
	public void setStorageListStr(String storageListStr) {
		this.storageListStr = storageListStr;
	}

	
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
		storageList=getStorageList();
		storageList.remove(storage);
	}
	
	
	public List<Storage> getStorageList() {
		String[] storages = storageListStr.split(" ");
		List<Storage> rst = new ArrayList<Storage>();
		
		for(String storage : storages) {
			String[] cur = storage.split(":");
			Storage stg = new Storage(cur[0],cur[1],Double.parseDouble(cur[2]),Double.parseDouble(cur[3]));
			rst.add(stg);
		}
		return rst;
	}
	public String getStorageListStr() {
		String rst = "";
		for(Storage storage: storageList) {
			rst+=storage.getId()+":"+storage.getProductName()+":"+storage.getNum()+":"+storage.getPrice()+" ";		
		}
		return rst.trim();
		 
	}
	public void setStorageListStr() {
		String rst = "";
		for(Storage storage: storageList) {
			rst+=storage.getId()+":"+storage.getProductName()+":"+storage.getNum()+":"+storage.getPrice()+" ";		
		}
		rst.trim();
		storageListStr = rst.trim();
	}
	public void setStorageList(List<Storage> storagelist) 
	{
		this.storageList = storagelist;
	}
	public String getStrageListStrFromList(List<Storage> storagelists) {
		String rst = "";
		for(Storage storage: storagelists) {
			rst+=storage.getId()+":"+storage.getProductName()+":"+
		storage.getNum()+":"+storage.getPrice()+" ";		
		}
		return rst.trim();
		
	}

}
