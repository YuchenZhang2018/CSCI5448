package com.zhang.ecommerce.strategy;

import com.zhang.ecommerce.Order;

public class PercentOffStrategy extends DiscountStrategy{

	@Override
	public double computeDiscount(Order order) {	
		return order.getTotalCost()*(1-Double.valueOf(strategyParams.get(0)));
	}

	@Override
	public StrategyType getStrategyType() {
		return StrategyType.PercentOff;
	}
	

}
