package com.performance.optimization.design.valueobject;

import java.io.Serializable;

/**
 * value object 订单类 可串行化
 * @author qiaolin
 *
 */
public class Order implements Serializable{

	private static final long serialVersionUID = 6685112428371713948L;

	private int orderId;
	
	private String clientName;
	
	private int number;
	
	private String productName ;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", clientName=" + clientName + ", number=" + number + ", productName="
				+ productName + "]";
	}
}
