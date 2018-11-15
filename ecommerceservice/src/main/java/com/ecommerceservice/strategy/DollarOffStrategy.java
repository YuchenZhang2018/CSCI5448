package com.ecommerceservice.strategy;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.ecommerceservice.model.common.Order;




public class DollarOffStrategy extends DiscountStrategy{
	

	public void init() {
		StrategyFactory.registerStrategy(this);
	}
	
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
