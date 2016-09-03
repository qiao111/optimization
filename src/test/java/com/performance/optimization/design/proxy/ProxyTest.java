package com.performance.optimization.design.proxy;

import org.junit.Test;

import com.performance.optimization.design.proxy.dynamic.DynamicProxy;

import javassist.CannotCompileException;
import javassist.NotFoundException;

public class ProxyTest {
	
	@Test
	public void testStaticProxy(){
		IDBQuery query = new DBQueryProxy();
		System.out.println(query.request());
	}

	/**
	 * 测试几种动态代理的效率
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NotFoundException
	 * @throws CannotCompileException
	 */
	@Test
	public void testDynamicProxy() throws InstantiationException, IllegalAccessException, NotFoundException, CannotCompileException{
		int circle = 300000000;
		IDBQuery query = null;
		System.out.println("========JdkProxy============");
		long begin = System.currentTimeMillis();
		query = DynamicProxy.createJDKProxy();
		System.out.println("createJDKProxy:" + (System.currentTimeMillis() - begin));
		System.out.println("JdkProxy class:" + query.getClass().getName());
		begin = System.currentTimeMillis();
		for(int i = 0; i<circle; i++){
			query.request();
		}
		System.out.println("call JdkProxy:" + (System.currentTimeMillis() - begin));
		System.out.println("========CglibProxy============");
		begin = System.currentTimeMillis();
		query = DynamicProxy.createCglibProxy();
		System.out.println("createCglibProxy:" + (System.currentTimeMillis() - begin));
		System.out.println("CglibProxy class:" + query.getClass().getName());
		begin = System.currentTimeMillis();
		for(int i = 0; i<circle; i++){
			query.request();
		}
		System.out.println("call CglibProxy:" + (System.currentTimeMillis() - begin));
		System.out.println("========JavassistHandler============");
		begin = System.currentTimeMillis();
		query = DynamicProxy.createJavassistProxyHandler();
		System.out.println("createJavassistProxyHandler:" + (System.currentTimeMillis() - begin));
		System.out.println("JavassistHandler class:" + query.getClass().getName());
		begin = System.currentTimeMillis();
		for(int i = 0; i<circle; i++){
			query.request();
		}
		System.out.println("call JavassistHandler:" + (System.currentTimeMillis() - begin));
		System.out.println("========JavassistBytecodeProxy============");
		begin = System.currentTimeMillis();
		query = DynamicProxy.createJavassistBytecodeProxy();
		System.out.println("createJavassistBytecodeProxy:" + (System.currentTimeMillis() - begin));
		System.out.println("JavassistBytecodeProxy class:" + query.getClass().getName());
		begin = System.currentTimeMillis();
		for(int i = 0; i<circle; i++){
			query.request();
		}
		System.out.println("call JavassistBytecodeProxy:" + (System.currentTimeMillis() - begin));
	}
}
