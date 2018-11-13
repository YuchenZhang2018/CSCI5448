package com.zhang.ecommerceservice.dao;

import com.zhang.ecommerceservice.model.common.Product;
import com.zhang.ecommerceservice.model.common.Storage;

public interface IStorageDao {
	void addStorage(Storage storage);
	boolean delStorage(Storage storage);
	Storage getStorage(Product product);
}
