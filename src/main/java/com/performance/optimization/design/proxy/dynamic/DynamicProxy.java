package com.performance.optimization.design.proxy.dynamic;

import java.lang.reflect.Proxy;

import com.performance.optimization.design.proxy.DBQuery;
import com.performance.optimization.design.proxy.IDBQuery;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import net.sf.cglib.proxy.Enhancer;

/**
 * 动态代理
 * @author qiaolin
 *
 */
public class DynamicProxy {
	
	/**
	 * 获取jdk 动态代理对象
	 * @return
	 */
	public static IDBQuery createJDKProxy(){
		IDBQuery query = (IDBQuery)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), //类加载器
				new Class[]{IDBQuery.class},//主题接口
				new JdkDBQueryHandler());//handler
		return query;
	}
	
	/**
	 * 使用Cglib创建动态代理对象
	 * @return
	 */
	public static IDBQuery createCglibProxy(){
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(new CglibDBQueryProxy());//指定切入点  回掉
		enhancer.setInterfaces(new Class[]{IDBQuery.class});//设置主题接口
		IDBQuery query = (IDBQuery) enhancer.create(); //创建代理对象
		return query;
	}
	
	
	/**
	 * 使用MethodHandler创建动态代理对象Javassist
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static IDBQuery createJavassistProxyHandler() throws InstantiationException, IllegalAccessException{
		ProxyFactory factory = new ProxyFactory();
		factory.setInterfaces(new Class[]{IDBQuery.class});
		Class proxyClass = factory.createClass();
		IDBQuery query =  (IDBQuery)  proxyClass.newInstance();
		((ProxyObject)query).setHandler(new JavassistProxyHandler());
		return query;
	}
	
	/**
	 * 字节码创建动态代理
	 * @return
	 * @throws NotFoundException 
	 * @throws CannotCompileException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static IDBQuery createJavassistBytecodeProxy() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException{
		ClassPool mPool = new ClassPool(true);
		//定义类名
		CtClass mCtc = mPool.makeClass(IDBQuery.class.getName() + "Javassist-BytecodeProxy");
		//需要实现的接口
		mCtc.addInterface(mPool.get(IDBQuery.class.getName()));
		//添加构造函数
		mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
		//设置字段信息
		mCtc.addField(CtField.make("public " + IDBQuery.class.getName() + " real;", mCtc));
		String dbqueryname = DBQuery.class.getName();
		mCtc.addMethod(CtNewMethod.make("public String request(){if(real==null)real = new " + dbqueryname + "();return real.request();}", mCtc));
		Class pc = mCtc.toClass();
		IDBQuery bytecodeproxy = (IDBQuery)pc.newInstance();
		return bytecodeproxy;
	}
	
}
