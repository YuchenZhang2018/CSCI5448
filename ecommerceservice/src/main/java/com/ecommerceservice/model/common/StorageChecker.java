package com.ecommerceservice.model.common;

import java.util.List;

import com.ecommerceservice.dao.CustomerDao;
import com.ecommerceservice.dao.ICustomerDao;
import com.ecommerceservice.dao.IStorageDao;
import com.ecommerceservice.dao.StorageDao;
import com.ecommerceservice.model.user.Customer;
import com.ecommerceservice.service.StorageService;
import com.ecommerceservice.service.StorageServiceImpl;
/**
 * Concrete Observer, when customer checkout,
 * StorageChecker will execute checkoutCheck() method, which will change customer.storageState
 */
public class StorageChecker extends Checker{
	private Customer customer;
	private ICustomerDao customerDao = new CustomerDao();
	private StorageService storageService = new StorageServiceImpl();

	public StorageChecker(Customer customer) {
		this.customer = customer;
		this.customer.attach(this);
	}
	
	@Override
	public void checkoutCheck() {
		List<Storage> storageList = customer.getCart().getStorageList();
		customer.setStorageState(true);
		for(Storage storage: storageList) {
			boolean state =storageService.checkStorage(storage);
			if(state==false) {
				customer.setStorageState(false);
				break;
			}
		}
		customerDao.updateCustomer(customer);
	}

}
