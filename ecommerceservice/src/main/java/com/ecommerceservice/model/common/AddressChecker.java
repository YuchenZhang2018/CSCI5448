package com.ecommerceservice.model.common;

import com.ecommerceservice.dao.CustomerDao;
import com.ecommerceservice.dao.ICustomerDao;
import com.ecommerceservice.model.user.Address;
import com.ecommerceservice.model.user.Customer;

/**
 * Concrete Observer, when customer checkout,
 * AddressChecker will execute checkoutCheck() method, which will change customer.addressState
 */
public class AddressChecker extends Checker{

	private Customer customer;
	private ICustomerDao customerDao = new CustomerDao();
	public AddressChecker(Customer customer) {
		this.customer = customer;
		this.customer.attach(this);
	}
	@Override
	public void checkoutCheck() {
		Address add = customer.getAddress();
		if(!add.getAddressLine().isEmpty() && !add.getCity().isEmpty() 
				&& !add.getState().isEmpty() && !add.getZip().isEmpty()) {
			customer.setAddressState(true);
		}else {
			customer.setAddressState(false);
		}
		customerDao.updateCustomer(customer);	
	}

}
