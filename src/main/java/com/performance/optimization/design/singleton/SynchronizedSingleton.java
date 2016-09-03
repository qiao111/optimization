package com.performance.optimization.design.singleton;


/**
 * 线程安全的懒加载的单例模式  采用同步进行实现 在多线程的环境下开销巨大
 * @author qiaolin
 *
 */
public class SynchronizedSingleton {
	
	private SynchronizedSingleton(){
		System.out.println("create lazy singleton");
	}
	
	/**
	 * 对静态成员变量instance初始值为null,确保系统启动时没有额外的负载
	 */
	private static SynchronizedSingleton instance = null;
	
	
	/**
	 * 采用同步进行实现确保唯一性 对多线程不友好
	 * @return
	 */
	public static synchronized SynchronizedSingleton getInstance(){
		if(instance == null){
			instance = new SynchronizedSingleton();
		}
		return instance ;
	}
	
	
	/**
	 * 调用此方法不会对实例化单例对象
	 */
	public static void createString(){
		System.out.println("create string --lazy singleton");
	}
	
	public static void main(String[] args) {
		SynchronizedSingleton.createString();
	}
}
