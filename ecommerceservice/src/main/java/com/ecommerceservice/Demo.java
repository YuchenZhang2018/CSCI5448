package com.ecommerceservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ecommerceservice.model.common.Storage;
import com.ecommerceservice.model.user.Customer;
import com.ecommerceservice.service.CustomerService;
import com.ecommerceservice.service.CustomerServiceImpl;
import com.ecommerceservice.service.StorageService;
import com.ecommerceservice.service.StorageServiceImpl;

public class Demo {
	
	private static StorageService storageSrv = new StorageServiceImpl();
	private static CustomerService customerSrv = new CustomerServiceImpl();
	public static void main(String args[]) {
		System.out.println("Please input your role：customer for C； admin for A");
		Scanner sc = new Scanner(System.in);
		String role  = sc.next();
		if("C".equals(role)) {
			customerDemo();
		}else if("A".equals(role)) {
			adminDemo();
		}else{
			System.out.println("Your input is wrong!");
		}

//		String name = sc.next();  //next()读取String类型的值
//		int age = sc.nextInt();  //nextInt()读取int类型的值
//		double weight = sc.nextDouble();  //nextDouble()读取double类型的值
//		System.out.println("姓名：" + name + ", 年龄：" + age + ", 体重：" + weight );
}
	private static void customerDemo() {
		String customerId = "testCustomer";
		System.out.println("These is our products, you can add them into your cart by the format'productName1:number productName2:number ... '");
		List<Storage> storagelist = storageSrv.showAllStorage();
		for(Storage storage:storagelist) {
			System.out.println("productName: "+storage.getProductName() + " price: " + storage.getPrice()+" num: "+storage.getNum());
		}
		Scanner sc = new Scanner(System.in);
		String productStr = sc.next();
	    
		List<Storage> storageChoose = splitStorage(productStr);
		customerSrv.addProduct2Cart(customerId, storageChoose);
		
		System.out.println("Do you want to review your cart? Y/N");
		Scanner sc2 = new Scanner(System.in);
		String viewCart = sc2.next();
		if("Y".equals(viewCart)) {
			reviewCartAndRmProducts(customerId);
			
		}
		System.out.println("Do you want to check out? Y/N");
		
		
		
		
	}
	private static void reviewCartAndRmProducts(String customerId) {
		Customer customerCur = customerSrv.getCustomerById(customerId);
		List<Storage> storagelistCur = customerCur.getCart().getStorageList();
		for(Storage cur: storagelistCur) {
			System.out.println("product name: "+cur.getProductName() + 
					" number: "+cur.getNum() +
					" price: "+cur.getPrice());
		}
		System.out.println("Do you want to remove some product from your cart? Y/N");
		Scanner sc2_1 = new Scanner(System.in);
		String rmPdc = sc2_1.next();
		if("Y".equals(rmPdc)) {
			System.out.println("Please remove product in format 'productName:removeNumber'");
			Scanner sc2_2 = new Scanner(System.in);
			String rmPdclist = sc2_2.next();
			List<Storage> rmStoragelistSplited = splitStorage(rmPdclist);
			customerSrv.deleteProductFromCart(customerId, rmStoragelistSplited);
		}
	}
	private static List<Storage> splitStorage(String productStr) {
		List<Storage> storageChoose = new ArrayList<Storage>();
		String[] productSplit1 = productStr.split(" ");
		for(String product: productSplit1) {
			String[] productNum = product.split(":");
			Storage cur = new Storage();
			cur.setProductName(productNum[0]);
			cur.setNum(Double.parseDouble(productNum[1]));
			storageChoose.add(cur);		
		}
		return storageChoose;
	}
	private static void adminDemo() {
		
	}
}
