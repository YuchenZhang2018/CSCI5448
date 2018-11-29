package com.ecommerceservice.service;

import java.util.List;

import com.ecommerceservice.model.product.ProductItem;
import com.ecommerceservice.model.user.StorageAdmin;

/**
 * storage admin service, can signup storage admin, signin storage admin,
 * delete storage admin by id, get storage admin by name and phone, add storage
 */
public interface StorageAdminService {

	void signup(StorageAdmin stgAdmin);
	boolean signin(StorageAdmin stgAdmin);
	void delete(String id);
	StorageAdmin getStorageByNameAndPhone(StorageAdmin admin);
	void addStorage(List<String[]> product);
}
