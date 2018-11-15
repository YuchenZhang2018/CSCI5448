package com.ecommerceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceservice.dao.CustomerDao;
import com.ecommerceservice.dao.ICustomerDao;
import com.ecommerceservice.model.user.Customer;

@Service
public class AdminServiceImpl implements AdminService{

	
	private ICustomerDao customerDao = new CustomerDao(); 
	@Override
	public void addCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);		
	}

}
