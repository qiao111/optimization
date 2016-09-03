package com.performance.optimization.design.valueobject;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI 服务端接口
 * @author qiaolin
 *
 */
public interface IOrderManager extends Remote{
	
	Order getOrder(int id) throws RemoteException;
	
	String getClientName(int id) throws RemoteException;
	
	String getProductName(int id) throws RemoteException;
	
	int getNumber(int id) throws RemoteException;

	boolean checkUser(int uid) throws RemoteException;

	boolean updateOrder(Order order) throws RemoteException;
}
