package com.performance.optimization.design.proxy;

/**
 * 真实实现类
 * @author qiaolin
 *
 */
public class DBQuery implements IDBQuery{
	
	public DBQuery(){
		//可能会进行一些数据库的链接等操作
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String request() {
		return "request string ";
	}
}
