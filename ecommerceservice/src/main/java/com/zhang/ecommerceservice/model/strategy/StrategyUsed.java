package com.zhang.ecommerceservice.model.strategy;

public class StrategyUsed {
	private static StrategyUsed instance;
	private static DiscountStrategy strategyUsed;
	private StrategyUsed() {}
	
	public static synchronized StrategyUsed getInstance() {
		if(instance==null) {
			instance = new StrategyUsed();
		}
		return instance;
	}
	public static synchronized void setStrategyUsed(DiscountStrategy strategy) {
		if(instance==null) {
			instance = new StrategyUsed();
			strategyUsed = strategy;
		}else {
			strategyUsed = strategy;
		}
	}
}
