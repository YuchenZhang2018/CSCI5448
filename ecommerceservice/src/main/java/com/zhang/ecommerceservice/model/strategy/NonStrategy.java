package com.zhang.ecommerceservice.model.strategy;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zhang.ecommerceservice.model.common.Order;


@Component
public class NonStrategy extends DiscountStrategy {

	@PostConstruct
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
