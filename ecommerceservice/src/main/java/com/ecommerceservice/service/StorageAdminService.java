package com.ecommerceservice.service;

import java.util.List;

import com.ecommerceservice.model.product.ProductItem;
import com.ecommerceservice.model.user.StorageAdmin;

public interface StorageAdminService {

	void signup(StorageAdmin stgAdmin);
	boolean signin(StorageAdmin stgAdmin);
	void delete(String id);
	StorageAdmin getStorageByNameAndPhone(StorageAdmin admin);
	void addStorage(List<String[]> product);
}
