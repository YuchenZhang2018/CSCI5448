package com.zhang.ecommerceservice.dao;

import org.junit.Assert;
import org.junit.Test;

import com.zhang.ecommerceservice.model.common.Product;
import com.zhang.ecommerceservice.model.common.Storage;

public class TestStorageDao {
	StorageDao dao = new StorageDao();
	@Test
	public void testAddStorage() {
		Storage storage = getNewStorageObject();
		dao.addStorage(storage);
		Storage rst = dao.getStorage(storage.getProduct());
		Assert.assertNotNull(rst);
		dao.addStorage(storage);
		Storage rst_added = dao.getStorage(storage.getProduct());
		//Assert.assertEquals(2*storage.getNum(),rst_added.getNum());
		storage.setNum(storage.getNum()*2);
		dao.delStorage(storage);
	}
	
	@Test
	public void testdDelStorage() {
		Storage storage = getNewStorageObject();
		dao.addStorage(storage);
		dao.delStorage(storage);
		Storage rst = dao.getStorage(storage.getProduct());
		//Assert.assertEquals(0, rst.getNum());
	}
	
	private Storage getNewStorageObject() {
		Product prod = new Product();
		prod.setBrand("testBrand");
		prod.setCategory("testCategory");
		prod.setProductName("testBrand_testProduct");
		prod.setPrice(12.12);
		prod.setInfo("testInfo");
		
		return new Storage(null, prod,3);
		
	}

}
