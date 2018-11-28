package com.ecommerceservice.strategy;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ecommerceservice.model.common.OrderModel;
import com.ecommerceservice.model.common.Storage;



public abstract class DiscountStrategy {
	protected StrategyType  strategyType;
	protected List<String> strategyParams;
	
	
	
	public DiscountStrategy() {
	}
	public DiscountStrategy(StrategyType strategyType, List<String> strategyParams) {
		this.strategyType = strategyType;
		this.strategyParams = strategyParams;
	}
	
	public  abstract double computeDiscount(List<Storage> storagelist); 
	public  abstract StrategyType getStrategyType();
	public  abstract String discountInfor() ;
	
	
	
	public List<String> getStrategyParams() {
		return strategyParams;
	}
	public void setStrategyParams(List<String> strategyParams) {
		this.strategyParams = strategyParams;
	}
	public double countOriginalCost(List<Storage> storagelist) {
		double totalBfDiscount = 0;
		for(Storage item:storagelist) {
			totalBfDiscount +=item.getPrice()*item.getNum();
		}
		return totalBfDiscount;
	}
}
