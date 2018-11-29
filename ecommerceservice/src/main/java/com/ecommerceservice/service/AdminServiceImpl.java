package com.ecommerceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceservice.dao.AdminDao;
import com.ecommerceservice.dao.CustomerDao;
import com.ecommerceservice.dao.IAdminDao;
import com.ecommerceservice.dao.ICustomerDao;
import com.ecommerceservice.model.user.Admin;
import com.ecommerceservice.model.user.Customer;

/**
 * admin service, can add customer, update customer,
 * signup admin, signin admin, delete admin by adminId, get admin by name and phone
 */
@Service
public class AdminServiceImpl implements AdminService{

	
	private ICustomerDao customerDao = new CustomerDao(); 
	private IAdminDao adminDao = new AdminDao();
	
	@Override
	public void addCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);		
	}

	@Override
	public void signup(Admin admin) {
		adminDao.saveAdmin(admin);
		
	}

	@Override
	public boolean signin(Admin admin) {
		Admin cur = adminDao.getAdminByNameAndPhone(admin);
		if(admin.getPassword()!=null && cur !=null && admin.getPassword().equals(cur.getPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public void delete(String id) {
		Admin admin = adminDao.getAdminById(id);
		adminDao.deleteAdmin(admin);
		
	}

	@Override
	public Admin getAdminByNameAndPhone(Admin admin) {
		
		return adminDao.getAdminByNameAndPhone(admin);
	}

	

}
