package com.performance.optimization.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.performance.optimization.design.proxy.DBQuery;

/**
 * jdk动态代理
 * @author qiaolin
 *
 */
public class JdkDBQueryHandler implements InvocationHandler {
	
	private DBQuery real;// 真实主题
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(real == null){
			real = new DBQuery();//创建真实主题
		}
		//调用真实主题
		Object result = method.invoke(real, args);
		return result;
	}
}
