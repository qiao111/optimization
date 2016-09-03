package com.performance.optimization.design.valueobject;

import java.rmi.RemoteException;

/**
 * 业务代理模式
 * @author qiaolin
 *
 */
public class BusinessDelegate {
	
	private IOrderManager orderManager;
	
	public BusinessDelegate(IOrderManager orderManager){
		this.orderManager = orderManager;
	}
	
	public boolean checkUserFromCache(int uid){
		return true;
	}
	
	public boolean checkUser(int uid) throws RemoteException{
		if(!checkUserFromCache(uid)){//当前对象被多个客户端共享时可从缓存中校验
			return orderManager.checkUser(1);
		}
		return true;
	}
	
	public Order getOrderFromCache(int oid){//从cache中获取订单
		return null;
	}
	
	public Order getOrder(int oid) throws RemoteException{
		Order order = getOrderFromCache(oid) ;
		if(order == null){
			return orderManager.getOrder(oid);
		}
		return order;
	}
	
	public boolean updateOrder(Order order) throws RemoteException{
		if(checkUser(order.getOrderId())){
			orderManager.updateOrder(order);
		}
		return true;
	}
}
