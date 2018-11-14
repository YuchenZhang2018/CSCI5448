package com.zhang.ecommerceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhang.ecommerceservice.dao.IStorageDao;
import com.zhang.ecommerceservice.model.common.Storage;

@Service
public class StorageServiceImpl implements StorageService{

	@Autowired
	private IStorageDao storageDao;
	
	@Override
	public void addStorage(Storage storage) {
		storageDao.addStorage(storage);
	}

	@Override
	public void delStorage(Storage storage) {
		storageDao.delStorage(storage);
		
	}
	

}
