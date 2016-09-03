package com.performance.optimization.design.valueobject;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.junit.Before;
import org.junit.Test;



public class ValueObjectTest {
	
	@Before
	public void before(){
		try {
			//注册端口 8081
			LocateRegistry.createRegistry(1099);
			IOrderManager orderManager = new OrderManager();
			//把指定名称重新绑定到一个新的远程对象
			Naming.rebind("OrderManager", orderManager);
			System.out.println("OrderManager is ready.");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test(){
		try {
			//获取远程对象
			IOrderManager orderManager = (IOrderManager) Naming.lookup("rmi://localhost:1099/OrderManager");
			int cycle = 1000;
			long begin = System.currentTimeMillis();
			for(int i = 0; i<cycle;i++){
				orderManager.getOrder(i);
			}
			System.out.println("Value Object Spend:" + (System.currentTimeMillis() - begin));
			begin = System.currentTimeMillis();
			for(int i = 0; i<cycle;i++){
				orderManager.getClientName(i);
				orderManager.getProductName(i);
				orderManager.getNumber(i);
			}
			System.out.println("Method called Spend:" + (System.currentTimeMillis() - begin));
			System.out.println(orderManager.getOrder(0).getClientName());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testBusinessDelegate(){
		try {
			IOrderManager orderManager = (IOrderManager) Naming.lookup("OrderManager");
			BusinessDelegate delegate = new BusinessDelegate(orderManager);
			Order order = new Order();
			order.setClientName("张三");
			order.setNumber(1);
			order.setOrderId(1);
			order.setProductName("剃须刀");
			delegate.updateOrder(order);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
	}
}
