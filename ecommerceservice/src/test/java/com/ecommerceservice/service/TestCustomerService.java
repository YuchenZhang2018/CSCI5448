package com.ecommerceservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ecommerceservice.dao.CustomerDao;
import com.ecommerceservice.dao.ICustomerDao;
import com.ecommerceservice.model.common.Storage;
import com.ecommerceservice.model.user.Address;
import com.ecommerceservice.model.user.Customer;

import junit.framework.Assert;

public class TestCustomerService {

	private CustomerService cusSrv= new CustomerServiceImpl();
	private ICustomerDao cusDao = new CustomerDao();
	
//	@Test
//	public void testAddProduct2Cart() {
//		Customer customer = getNewCustomer();
//		cusSrv.signup(customer);
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("name", customer.getName());
//		Customer c = cusDao.getCustomer(map);
//		cusSrv.addProduct2Cart(c.getId(),getProducts());
//		Customer c2 = cusDao.getCustomer(map);
//		Assert.assertNotNull(c2.getCart().getStorageListStr());
//		cusDao.deleteCustomer(c);
//		
//	}
//	@Test
//	public void testRemoveProductFromCart() {
//		Customer customer = getNewCustomer();
//		cusSrv.signup(customer);
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("name", customer.getName());
//		Customer c = cusDao.getCustomer(map);
//		List<Storage> products = getProducts();
//		cusSrv.addProduct2Cart(c.getId(),products);
//		List<Storage> prdRm = new ArrayList<Storage>();
//		prdRm.add(products.get(0));
//		cusSrv.deleteProductFromCart(c.getId(), prdRm);
//		Customer c2 = cusDao.getCustomer(map);
//		Assert.assertNotNull(c2.getCart().getStorageListStr());
//		cusDao.deleteCustomer(c);
//		
//	}
	private List<Storage> getProducts(){
		List<Storage> rst = new ArrayList<Storage>();
		Storage s1 = new Storage("0001", "Sunny_Milk", 2, 2.7);
		Storage s2 = new Storage("0002", "Sunny_Bread", 3, 4.7);
		rst.add(s1);
		rst.add(s2);
		
		return rst;
	}
	private Customer getNewCustomer() {
		Customer customer = new Customer();
		customer.setEmail("test email");
		customer.setName("testName");
		customer.setPhone("testPhone");
		Address add = new Address();
		add.setAddressLine("testAddLine");
		add.setCity("testCity");
		add.setState("testState");
		add.setZip("testZIP");
		return customer;
	}
	
}
