package com.ecommerceservice.dao;

import java.util.List;
import java.util.Map;

import com.ecommerceservice.model.common.Product;
import com.ecommerceservice.model.common.ProductSearchFilter;

public interface IProductDao {
	List<Product> searchProduct(Map<String,String> filter);

}
