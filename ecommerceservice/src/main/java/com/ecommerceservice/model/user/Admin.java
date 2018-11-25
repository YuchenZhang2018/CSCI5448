package com.ecommerceservice.model.user;

import java.util.List;

import com.ecommerceservice.strategy.DiscountStrategy;
import com.ecommerceservice.strategy.StrategyFactory;
import com.ecommerceservice.strategy.StrategyType;
import com.ecommerceservice.strategy.StrategyUsed;



public class Admin {
	private String adminId;
	private String name;
	private String phone;
	private String password;
	public void setDiscountStrategy(StrategyType type, List<String> params) {
		DiscountStrategy strategy = StrategyFactory.getStrategy(type);
		strategy.setStrategyParams(params);
		StrategyUsed.setStrategyUsed(strategy);
	}
	public Admin() {
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(String adminId, String name, String phone, String password) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.phone = phone;
		this.password = password;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
