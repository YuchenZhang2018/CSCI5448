package com.ecommerceservice.service;

import java.util.List;

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

	@Override
	public boolean checkStorage(Storage storage) {
		Storage rst = storageDao.getStorage(storage.getProductName());
		if(rst==null || rst.getNum()<storage.getNum()){
			return false;
		}
		return true;
	}

	@Override
	public List<Storage> showAllStorage() {
		
		return storageDao.getAllStorage();
	}
	

}
