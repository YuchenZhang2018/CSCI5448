package com.zhang.ecommerceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhang.ecommerceservice.dao.ICustomerDao;
import com.zhang.ecommerceservice.model.user.Customer;

@Service
public class AdminCustomerImpl implements AdminService{

	@Autowired 
	private ICustomerDao customerDao; 
	@Override
	public void addCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);		
	}

}
