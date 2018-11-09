package com.zhang.ecommerceservice.model.strategy;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zhang.ecommerceservice.model.common.Order;

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
