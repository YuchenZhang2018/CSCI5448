package com.ecommerceservice.strategy;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.ecommerceservice.model.common.OrderModel;
import com.ecommerceservice.model.common.Storage;

@Component
public class PercentOffStrategy extends DiscountStrategy{
	

	@PostConstruct
	public void init() {
		StrategyFactory.registerStrategy(this);
	}
	
	@Override
	public double computeDiscount(List<Storage> storagelist) {	
		
		return countOriginalCost(storagelist)*(1-Double.valueOf(strategyParams.get(0))/100);
	}

	@Override
	public StrategyType getStrategyType() {
		return StrategyType.PercentOff;
	}

	@Override
	public String discountInfor() {
   
		return strategyParams.get(0)+"%OFF";
	}
	
	

}
