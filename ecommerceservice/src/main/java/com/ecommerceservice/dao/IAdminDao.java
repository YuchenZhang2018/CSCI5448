package com.ecommerceservice.dao;

import com.ecommerceservice.model.user.Admin;

public interface IAdminDao {
	void saveAdmin(Admin admin);
	void deleteAdmin(Admin admin);
	Admin getAdminById(String id);
	Admin getAdminByNameAndPhone(Admin admin);
	
}
