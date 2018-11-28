package com.ecommerceservice.service;

import java.util.List;

import com.ecommerceservice.dao.IStorageAdminDao;
import com.ecommerceservice.dao.IStorageDao;
import com.ecommerceservice.dao.StorageAdminDao;
import com.ecommerceservice.dao.StorageDao;
import com.ecommerceservice.model.product.ProductCache;
import com.ecommerceservice.model.product.ProductItem;
import com.ecommerceservice.model.user.StorageAdmin;

public class StorageAdminServiceImpl implements StorageAdminService{
	private IStorageAdminDao dao = new StorageAdminDao();
	private IStorageDao storageDao = new StorageDao();

	@Override
	public void signup(StorageAdmin stgAdmin) {
		dao.saveAdmin(stgAdmin);
		
	}

	@Override
	public boolean signin(StorageAdmin stgAdmin) {
		StorageAdmin cur = dao.getStorageAdminByNameAndPhone(stgAdmin);
		if(cur!=null && stgAdmin.getPassword().equals(cur.getPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public void delete(String id) {
		StorageAdmin cur = dao.getStorageAdminById(id);
		dao.deleteAdminById(cur);
		
	}

	@Override
	public StorageAdmin getStorageByNameAndPhone(StorageAdmin admin) {
		return dao.getStorageAdminByNameAndPhone(admin); 
	}

	@Override
	public void addStorage(List<String[]> products) {
		ProductCache.loadCache();
		
		for(String[] item: products) {
			ProductItem clonedProduct = (ProductItem) ProductCache.getProduct(item[0]);
			clonedProduct.setProductName(item[1]);
			clonedProduct.setPrice(Double.parseDouble(item[2]));
			storageDao.addStorage(clonedProduct.getStorage(Double.parseDouble(item[3])));
		      
		}
		
	}

}
