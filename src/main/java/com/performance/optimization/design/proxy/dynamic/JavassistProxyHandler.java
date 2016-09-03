package com.performance.optimization.design.proxy.dynamic;

import java.lang.reflect.Method;

import com.performance.optimization.design.proxy.DBQuery;

import javassist.util.proxy.MethodHandler;

/**
 * 使用MethodHandler 创建动态代理
 * @author qiaolin
 *
 */
public class JavassistProxyHandler implements MethodHandler{

	private DBQuery real;

	public Object invoke(Object arg0, Method arg1, Method arg2, Object[] arg3) throws Throwable {
		if(real == null){
			real = new DBQuery();
		}
		return real.request();
	}

}
