package com.ecommerceservice.dao;

import java.util.List;

import com.ecommerceservice.model.common.Storage;

/**
 * Storage Dao: can add, get, delete storage
 */
public interface IStorageDao {
	void addStorage(Storage storage);
	boolean delStorage(Storage storage);
	Storage getStorage(String productName);
	List<Storage> getAllStorage();
}
