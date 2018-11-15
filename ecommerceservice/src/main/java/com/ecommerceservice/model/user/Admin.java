package com.ecommerceservice.model.user;

import java.util.List;

import com.ecommerceservice.strategy.DiscountStrategy;
import com.ecommerceservice.strategy.StrategyFactory;
import com.ecommerceservice.strategy.StrategyType;
import com.ecommerceservice.strategy.StrategyUsed;



public class Admin {
	private String adminId;
	private String name;
	public void setDiscountStrategy(StrategyType type, List<String> params) {
		DiscountStrategy strategy = StrategyFactory.getStrategy(type);
		strategy.setStrategyParams(params);
		StrategyUsed.setStrategyUsed(strategy);
	}
	public Admin() {
		super();
	}
	public Admin(String adminId, String name) {
		super();
		this.adminId = adminId;
		this.name = name;
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
