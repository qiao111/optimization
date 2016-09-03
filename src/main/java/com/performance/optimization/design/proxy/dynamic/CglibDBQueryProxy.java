package com.performance.optimization.design.proxy.dynamic;

import java.lang.reflect.Method;

import com.performance.optimization.design.proxy.DBQuery;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
 * cglib动态代理 
 * @author qiaolin
 *
 */
public class CglibDBQueryProxy implements MethodInterceptor{
	
	private DBQuery real;
	
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		if(real == null){
			real = new DBQuery();
		}
		Object result = proxy.invoke(real, args);
		return result;
	}

}
