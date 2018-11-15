package com.ecommerceservice.dao;

import com.ecommerceservice.model.common.Product;
import com.ecommerceservice.model.common.Storage;

public interface IStorageDao {
	void addStorage(Storage storage);
	boolean delStorage(Storage storage);
	Storage getStorage(Product product);
}
