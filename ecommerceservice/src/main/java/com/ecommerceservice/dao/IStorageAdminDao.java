package com.ecommerceservice.dao;

import com.ecommerceservice.model.user.StorageAdmin;

/**
 * StorageAdmin Dao: can save storageAdmin, delete storageAdmin by id, and get storage admin by id or by name and phone.
 */
public interface IStorageAdminDao {
	void saveAdmin(StorageAdmin admin);
	void deleteAdminById(StorageAdmin admin);
	StorageAdmin getStorageAdminById(String id);
	StorageAdmin getStorageAdminByNameAndPhone(StorageAdmin admin);
}
