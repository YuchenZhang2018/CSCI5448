package com.ecommerceservice.strategy;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;


public class StrategyFactory {
	private static Map<StrategyType,DiscountStrategy> strategyMap;
	
	public StrategyFactory() {
		strategyMap = new HashMap<StrategyType, DiscountStrategy>();
	}

	public static void registerStrategy(DiscountStrategy strategy) {
		strategyMap.put(strategy.strategyType, strategy);
	}
	public static DiscountStrategy getStrategy(StrategyType type) {
		return strategyMap.get(type);
	}
}
