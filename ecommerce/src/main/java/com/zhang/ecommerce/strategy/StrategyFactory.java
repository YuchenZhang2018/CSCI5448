package com.zhang.ecommerce.strategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {
	private static Map<StrategyType,DiscountStrategy> strategyMap;
	
	public StrategyFactory() {
		strategyMap = new HashMap<>();
	}

	public void registerStrategy(DiscountStrategy strategy) {
		strategyMap.put(strategy.strategyType, strategy);
	}
	public static DiscountStrategy getStrategy(StrategyType type) {
		return strategyMap.get(type);
	}
}
