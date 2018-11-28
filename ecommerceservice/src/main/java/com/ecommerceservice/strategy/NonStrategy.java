package com.ecommerceservice.strategy;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.ecommerceservice.model.common.OrderModel;
import com.ecommerceservice.model.common.Storage;


@Component
public class NonStrategy extends DiscountStrategy {

	@PostConstruct
	public void init() {
		StrategyFactory.registerStrategy(this);
	}
	
	

	@Override
	public StrategyType getStrategyType() {
		return StrategyType.Non;
	}

	@Override
	public double computeDiscount(List<Storage> storagelist) {
		
		return countOriginalCost(storagelist);
	}

	@Override
	public String discountInfor() {
		
		return "Non-discount.";
	}

}
