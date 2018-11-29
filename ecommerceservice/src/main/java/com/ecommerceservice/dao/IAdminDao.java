package com.ecommerceservice.dao;

import com.ecommerceservice.model.user.Admin;
/**
 * Admin Dao: can save, delete admin, can get admin by adminId or by admin name and phone
 */
public interface IAdminDao {
	void saveAdmin(Admin admin);
	void deleteAdmin(Admin admin);
	Admin getAdminById(String id);
	Admin getAdminByNameAndPhone(Admin admin);
	
}
