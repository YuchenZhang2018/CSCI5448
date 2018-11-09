package com.zhang.ecommerce.user;

public class PaymentInfo {
	private String payMethod;
	private String accountInfo;
	public PaymentInfo() {
		super();
	}
	public PaymentInfo(String payMethod, String accountInfo) {
		super();
		this.payMethod = payMethod;
		this.accountInfo = accountInfo;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getAccountInfo() {
		return accountInfo;
	}
	public void setAccountInfo(String accountInfo) {
		this.accountInfo = accountInfo;
	}
	

}
