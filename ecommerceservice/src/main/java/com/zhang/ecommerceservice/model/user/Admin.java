package com.zhang.ecommerce.user;

import java.util.List;

import com.zhang.ecommerce.strategy.DiscountStrategy;
import com.zhang.ecommerce.strategy.StrategyFactory;
import com.zhang.ecommerce.strategy.StrategyType;
import com.zhang.ecommerce.strategy.StrategyUsed;

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
