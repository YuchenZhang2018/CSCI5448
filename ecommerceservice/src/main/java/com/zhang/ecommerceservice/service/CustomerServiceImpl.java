package com.zhang.ecommerceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhang.ecommerceservice.dao.ICustomerDao;
import com.zhang.ecommerceservice.model.user.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private ICustomerDao customerDao;

	@Override
	public void signup(Customer c) {
		customerDao.saveCustomer(c);
	}

	@Override
	public void login(String usrName, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout(String usrName) {
		// TODO Auto-generated method stub

	}


}
