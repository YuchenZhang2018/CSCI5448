package com.ecommerceservice.model.user;


/**
 * Address class
 */
public class Address {

	private String addressLine;
	private String city;
	private String state;
	private String zip;
	
	public Address(){}
	public Address(String addressLine, String city, String state, String zip) {
		this.addressLine=addressLine;
		this.city = city;
		this.state =state;
		this.zip = zip;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getAddressLine() {
		return addressLine;
	}
	
	
}
