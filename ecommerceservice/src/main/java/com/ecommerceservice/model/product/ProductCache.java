package com.ecommerceservice.model.product;

import java.util.HashMap;
import java.util.Map;

/**
 * Cache ProductItem
 */
public class ProductCache {
	private static Map<String, ProductItem> prodcutMap 
    = new HashMap<String, ProductItem>();

 public static ProductItem getProduct(String categary) {
	 ProductItem cachedProduct = prodcutMap.get(categary);
    return (ProductItem) cachedProduct.clone();
 }

 public static void loadCache() {
    Food food = new Food();
    prodcutMap.put(food.getCategary(),food);

    Paper paper = new Paper();
    prodcutMap.put(paper.getCategary(),paper);

    Toy toy = new Toy();
    prodcutMap.put(toy.getCategary(),toy);
 }
}
