package com.zhang.ecommerce.strategy;

import com.zhang.ecommerce.Order;

public class DollarOffStrategy extends DiscountStrategy{	
	@Override
	public double computeDiscount(Order order) {
        double total = order.getTotalCost();
		if(total>=Double.valueOf(strategyParams.get(0))) {
			total -= Double.valueOf(strategyParams.get(1));
		}
		return total;
	}
	@Override
	public StrategyType getStrategyType() {
		return StrategyType.DollarOff;
	}
	

}
