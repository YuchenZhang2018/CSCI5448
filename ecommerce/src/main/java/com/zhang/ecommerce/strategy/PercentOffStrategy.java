package com.zhang.ecommerce.strategy;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zhang.ecommerce.Order;

@Component
public class PercentOffStrategy extends DiscountStrategy{
	

	@PostConstruct
	public void init() {
		StrategyFactory.registerStrategy(this);
	}
	
	@Override
	public double computeDiscount(Order order) {	
		return order.getTotalCost()*(1-Double.valueOf(strategyParams.get(0)));
	}

	@Override
	public StrategyType getStrategyType() {
		return StrategyType.PercentOff;
	}
	
	

}
