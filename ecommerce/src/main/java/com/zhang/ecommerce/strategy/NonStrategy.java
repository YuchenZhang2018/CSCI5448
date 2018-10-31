package com.zhang.ecommerce.strategy;

import com.zhang.ecommerce.Order;

public class NonStrategy extends DiscountStrategy {

	@Override
	public double computeDiscount(Order order) {
		return order.getTotalCost();
	}

	@Override
	public StrategyType getStrategyType() {
		return StrategyType.Non;
	}

}
