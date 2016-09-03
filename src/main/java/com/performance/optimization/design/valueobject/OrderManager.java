package com.performance.optimization.design.valueobject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 订单接口的实现类
 * @author qiaolin
 *
 */
public class OrderManager extends UnicastRemoteObject implements IOrderManager{

	protected OrderManager() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	public Order getOrder(int id) throws RemoteException {
		Order order = new Order();
		order.setClientName("Client Name");
		order.setNumber(10);
		order.setProductName("Product Name");
		return order;
	}

	public String getClientName(int id) throws RemoteException {
		return "Client Name";
	}

	public String getProductName(int id) throws RemoteException {
		return "Product Name";
	}

	public int getNumber(int id) throws RemoteException {
		return 10;
	}

	public boolean checkUser(int uid) throws RemoteException{
		return true;
	}

	public boolean updateOrder(Order order) throws RemoteException{
		System.out.println("更新订单操作");
		System.out.println(order);
		return true;
	}

}
