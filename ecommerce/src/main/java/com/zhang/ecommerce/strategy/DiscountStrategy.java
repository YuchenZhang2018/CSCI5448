package com.zhang.ecommerce.strategy;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zhang.ecommerce.Order;

@Component
public abstract class DiscountStrategy {
	protected StrategyType  strategyType;
	protected List<String> strategyParams;
	
	
	public DiscountStrategy() {
	}
	public DiscountStrategy(StrategyType strategyType, List<String> strategyParams) {
		this.strategyType = strategyType;
		this.strategyParams = strategyParams;
	}
	
	public  abstract double computeDiscount(Order order); 
	public  abstract StrategyType getStrategyType();	
	
	public List<String> getStrategyParams() {
		return strategyParams;
	}
	public void setStrategyParams(List<String> strategyParams) {
		this.strategyParams = strategyParams;
	}
}
