package com.zhang.ecommerce.strategy;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zhang.ecommerce.Order;

@Component
public abstract class DiscountStrategy {
	protected StrategyType  strategyType;
	public List<String> getStrategyParams() {
		return strategyParams;
	}


	public void setStrategyParams(List<String> strategyParams) {
		this.strategyParams = strategyParams;
	}


	protected List<String> strategyParams;
	
	
	public DiscountStrategy(StrategyType strategyType, List<String> strategyParams) {
		super();
		this.strategyType = strategyType;
		this.strategyParams = strategyParams;
	}


	public DiscountStrategy() {
		super();
	}


	public  abstract double computeDiscount(Order order); 
	public  abstract StrategyType getStrategyType();	

}
