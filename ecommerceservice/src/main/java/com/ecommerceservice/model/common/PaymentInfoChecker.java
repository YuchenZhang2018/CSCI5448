package com.ecommerceservice.model.common;

import com.ecommerceservice.dao.CustomerDao;
import com.ecommerceservice.dao.ICustomerDao;
import com.ecommerceservice.model.user.Customer;
import com.ecommerceservice.model.user.PaymentInfo;
/**
 * Concrete Observer, when customer checkout,
 * PaymentInfoChecker will execute checkoutCheck() method, which will change customer.paymentState
 */
public class PaymentInfoChecker extends Checker{

	private Customer customer;
	private ICustomerDao customerDao = new CustomerDao();
	public PaymentInfoChecker(Customer customer) {
		this.customer = customer;
		this.customer.attach(this);
	}
	@Override
	public void checkoutCheck() {
		
		PaymentInfo payInfo = customer.getPaymentInfo();
		if(!payInfo.getAccountInfo().isEmpty() && !payInfo.getPayMethod().isEmpty()) {
			customer.setPaymentState(true);
		}else {
			customer.setPaymentState(false);
		}
		customerDao.updateCustomer(customer);
	}

}
