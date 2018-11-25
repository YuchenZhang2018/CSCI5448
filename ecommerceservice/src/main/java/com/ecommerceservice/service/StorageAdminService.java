package com.ecommerceservice.service;

import com.ecommerceservice.model.user.StorageAdmin;

public interface StorageAdminService {

	void signup(StorageAdmin stgAdmin);
	boolean signin(StorageAdmin stgAdmin);
	void delete(String id);
	StorageAdmin getStorageByNameAndPhone(StorageAdmin admin);
}
