package com.ecommerceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceservice.dao.IStorageDao;
import com.ecommerceservice.dao.StorageDao;
import com.ecommerceservice.model.common.Storage;

@Service
public class StorageServiceImpl implements StorageService{

	
	private IStorageDao storageDao = new StorageDao();
	
	@Override
	public void addStorage(Storage storage) {
		storageDao.addStorage(storage);
	}

	@Override
	public void delStorage(Storage storage) {
		storageDao.delStorage(storage);
		
	}
	

}
