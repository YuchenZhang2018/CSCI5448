package com.ecommerceservice;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

import com.ecommerceservice.model.common.OrderModel;
import com.ecommerceservice.model.common.Storage;
import com.ecommerceservice.model.user.Address;
import com.ecommerceservice.model.user.Customer;
import com.ecommerceservice.service.CustomerService;
import com.ecommerceservice.service.CustomerServiceImpl;
import com.ecommerceservice.service.StorageAdminService;
import com.ecommerceservice.service.StorageAdminServiceImpl;
import com.ecommerceservice.service.StorageService;
import com.ecommerceservice.service.StorageServiceImpl;
import com.ecommerceservice.strategy.DiscountStrategy;
import com.ecommerceservice.strategy.DollarOffStrategy;
import com.ecommerceservice.strategy.NonStrategy;
import com.ecommerceservice.strategy.PercentOffStrategy;
import com.ecommerceservice.strategy.StrategyFactory;
import com.ecommerceservice.strategy.StrategyType;
import com.ecommerceservice.strategy.StrategyUsed;

public class Demo {
	
	
	private static StorageService storageSrv = new StorageServiceImpl();
	private static CustomerService customerSrv = new CustomerServiceImpl();
	private static StorageAdminService storageAdmin = new StorageAdminServiceImpl();
	public static void main(String args[]) {
//		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.INFO);
		
		
		System.out.println("Are you storage admin? Y/N ");
		Scanner sa = new Scanner(System.in);
		if("Y".equals(sa.next())) {
			System.out.println("Please add storage in format 'categary:productName:price:num'");
			Scanner sa_prodlist = new Scanner(System.in);
			String[] sa_split = sa_prodlist.nextLine().split(" ");
	        List<String[]> productstr = new ArrayList<String[]>();
	        for(String product: sa_split) {
	        	productstr.add(product.split(":"));
	        }
	        storageAdmin.addStorage(productstr);	        
		}
		
		adminPrepare();
		System.out.println("Are you admin? Y/N");
		Scanner sad = new Scanner(System.in);
		if("Y".equals(sad.next())) {
			System.out.println("Please choose today's discount strategy: 1. DollarOffStrategy 2. PercentOff Strategy 3. none discount strategy");
			Scanner strategyTypesc = new Scanner(System.in);
			String strategyTp = strategyTypesc.next();
			DiscountStrategy strategy;
			if("1".equals(strategyTp) || "2".equals(strategyTp)) {
				System.out.println("please input params in format 'param1 param2'");
				Scanner paramsc = new Scanner(System.in);
				String[] param = paramsc.nextLine().split(":");
				List<String> paramlist = new ArrayList<String>();
				for(String i: param) {
					paramlist.add(i);
				}
				
				if("1".equals(strategyTp)) {
					strategy = StrategyFactory.getStrategy(StrategyType.DollarOff);
//					strategy = new DollarOffStrategy(); 
					strategy.setStrategyParams(paramlist);
				}else {
					strategy = StrategyFactory.getStrategy(StrategyType.PercentOff);
//					strategy = new PercentOffStrategy();
					strategy.setStrategyParams(paramlist);
				}	
			}else {
				strategy = StrategyFactory.getStrategy(StrategyType.Non);
//				strategy = new NonStrategy();
			}
			StrategyUsed.setStrategyUsed(strategy);
		}
		
		System.out.println("Are you customer? Y/N ");
		Scanner sc = new Scanner(System.in);
		String role  = sc.next();
		if("Y".equals(role)) {
			customerDemo();
		}

//		String name = sc.next();  //next()读取String类型的值
//		int age = sc.nextInt();  //nextInt()读取int类型的值
//		double weight = sc.nextDouble();  //nextDouble()读取double类型的值
//		System.out.println("姓名：" + name + ", 年龄：" + age + ", 体重：" + weight );
}
	private static void customerDemo() {
		
		String customerId = "8a80804e6756b362016756b364790000";
		System.out.println("These is our products, you can add them into your cart by the format'productName1:number productName2:number ... '");
		List<Storage> storagelist = storageSrv.showAllStorage();
		for(Storage storage:storagelist) {
			System.out.println("productName: "+storage.getProductName() + " price: " + storage.getPrice()+" num: "+storage.getNum());
		}
		Scanner sc = new Scanner(System.in);	
		List<Storage> storageChoose = splitStorage(sc.nextLine());
		customerSrv.addProduct2Cart(customerId, storageChoose);
		
		System.out.println("Do you want to review your cart? Y/N");
		Scanner sc2 = new Scanner(System.in);
		String viewCart = sc2.next();
		if("Y".equals(viewCart)) {
			reviewCartAndRmProducts(customerId);
			
		}
		System.out.println("Do you want to check out? Y/N");
		Scanner sc3 = new Scanner(System.in);
		String checkout = sc3.next();
		if("Y".equals(checkout)) {
			OrderModel order = customerSrv.checkout(customerId);
			System.out.println("OrderId:"+order.getOrderID());
			System.out.println("productlist:");
			List<Storage> products = getStoragefromStr(order.getProductStr());
			for(Storage product:products) {
				System.out.println("product name: "+product.getProductName()+" number: "+product.getNum()+
						" price: "+product.getPrice());
			}
			System.out.println("Distcount strategy: "+order.getDiscountStrategyInfo());
			System.out.println("saving: "+String.valueOf(order.getSaving()));
			System.out.println("tax: " + String.valueOf(order.getTax()));
			System.out.println("Total cost: "+ String.valueOf(order.getTotalcost()));
			
		}	
	}
	
	private static void reviewCartAndRmProducts(String customerId) {
		Customer customerCur = customerSrv.getCustomerById(customerId);
		List<Storage> storagelistCur = customerCur.getCart().getStorageList();
		for(Storage cur: storagelistCur) {
			System.out.println("product name: "+cur.getProductName() + 
					" number: "+cur.getNum() +
					" price: "+cur.getPrice());
		}
//		System.out.println("Do you want to remove some product from your cart? Y/N");
//		Scanner sc2_1 = new Scanner(System.in);
//		String rmPdc = sc2_1.next();
//		if("Y".equals(rmPdc)) {
//			System.out.println("Please remove product in format 'productName:removeNumber'");
//			Scanner sc2_2 = new Scanner(System.in);
//			String rmPdclist = sc2_2.next();
//			List<Storage> rmStoragelistSplited = splitStorage(rmPdclist);
//			customerSrv.deleteProductFromCart(customerId, rmStoragelistSplited);
//		}
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
	private static List<Storage> getStoragefromStr(String storageStr) {
		List<Storage> storageChoose = new ArrayList<Storage>();
		String[] productSplit1 = storageStr.split(" ");
		for(String product: productSplit1) {
			String[] productInfo = product.split(":");
			Storage cur = new Storage();
			cur.setId(productInfo[0]);
			cur.setProductName(productInfo[1]);
			cur.setNum(Double.parseDouble(productInfo[2]));
			cur.setPrice(Double.parseDouble(productInfo[3]));
			storageChoose.add(cur);		
		}
		return storageChoose;
	}
	private static void adminPrepare() {
		DollarOffStrategy strategy1 = new DollarOffStrategy();
		strategy1.init();
		PercentOffStrategy strategy2 = new PercentOffStrategy();
		strategy2.init();
		NonStrategy strategy3 = new NonStrategy();
		strategy3.init();
	}
	
}
