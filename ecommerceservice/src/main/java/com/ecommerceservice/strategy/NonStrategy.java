package com.ecommerceservice.strategy;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.ecommerceservice.model.common.Order;



public class NonStrategy extends DiscountStrategy {

	
	public void init() {
		StrategyFactory.registerStrategy(this);
	}
	
	@Override
	public double computeDiscount(Order order) {
		return order.getTotalCost();
	}

	@Override
	public StrategyType getStrategyType() {
		return StrategyType.Non;
	}

}
