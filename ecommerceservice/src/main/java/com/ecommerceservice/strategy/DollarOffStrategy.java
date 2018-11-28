package com.ecommerceservice.strategy;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.ecommerceservice.model.common.OrderModel;
import com.ecommerceservice.model.common.Storage;



@Component
public class DollarOffStrategy extends DiscountStrategy{
	
    @PostConstruct
	public void init() {
		StrategyFactory.registerStrategy(this);
	}
	
	@Override
	public StrategyType getStrategyType() {
		return StrategyType.DollarOff;
	}

	@Override
	public double computeDiscount(List<Storage> storagelist) {
		double total = countOriginalCost(storagelist);
		if(total>=Double.valueOf(strategyParams.get(0))) {
			total -= Double.valueOf(strategyParams.get(1));
		}
		return total;
	}

	@Override
	public String discountInfor() {
		return "Buying "+strategyParams.get(0)+" saving "+strategyParams.get(1);
	}
	

}
