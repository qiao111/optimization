package com.performance.optimization.design.proxy;

public class DBQueryProxy implements IDBQuery{
	
	private DBQuery real;
	
	public String request() {
		//创建真实类
		if(real == null){
			real = new DBQuery();
		}
		//调用真实业务
		return real.request();
	}

}
