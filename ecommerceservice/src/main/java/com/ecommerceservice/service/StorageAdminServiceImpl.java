package com.ecommerceservice.service;

import com.ecommerceservice.dao.IStorageAdminDao;
import com.ecommerceservice.dao.StorageAdminDao;
import com.ecommerceservice.model.user.StorageAdmin;

public class StorageAdminServiceImpl implements StorageAdminService{
	private IStorageAdminDao dao = new StorageAdminDao();

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

}
