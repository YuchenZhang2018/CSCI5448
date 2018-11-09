package com.zhang.ecommerceservice.model.strategy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class StrategyFactory {
	private static Map<StrategyType,DiscountStrategy> strategyMap;
	
	public StrategyFactory() {
		strategyMap = new HashMap<>();
	}

	public static void registerStrategy(DiscountStrategy strategy) {
		strategyMap.put(strategy.strategyType, strategy);
	}
	public static DiscountStrategy getStrategy(StrategyType type) {
		return strategyMap.get(type);
	}
}
