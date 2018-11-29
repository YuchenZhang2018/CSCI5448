package com.ecommerceservice.service;

import java.util.List;

import com.ecommerceservice.model.common.Storage;

/**
 * storage service, can add storage, delete storage, check storage, show all storage
 */
public interface StorageService {
	void addStorage(Storage storage);
	void delStorage(Storage storage);
	boolean checkStorage(Storage storage);
	List<Storage> showAllStorage();
}
