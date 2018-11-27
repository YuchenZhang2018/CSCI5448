package com.ecommerceservice.service;

import java.util.List;

import com.ecommerceservice.model.common.Storage;

public interface StorageService {
	void addStorage(Storage storage);
	void delStorage(Storage storage);
	boolean checkStorage(Storage storage);
	List<Storage> showAllStorage();
}
