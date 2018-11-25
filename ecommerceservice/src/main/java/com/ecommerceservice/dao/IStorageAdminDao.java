package com.ecommerceservice.dao;

import com.ecommerceservice.model.user.StorageAdmin;

public interface IStorageAdminDao {
	void saveAdmin(StorageAdmin admin);
	void deleteAdminById(StorageAdmin admin);
	StorageAdmin getStorageAdminById(String id);
	StorageAdmin getStorageAdminByNameAndPhone(StorageAdmin admin);
}
