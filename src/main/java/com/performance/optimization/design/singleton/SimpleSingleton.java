package com.performance.optimization.design.singleton;


/**
 * 最简单的单例模式  
 * 不足之处：无法实现instance的延迟加载，
 * 由于instance是static的,因此在JVM加载单例类时，单例对象会被创建，
 * 如果此时单例类还扮演其他角色，则在使用单例类的这个地方都会实例化单例类。
 * @author qiaolin
 *
 */
public class SimpleSingleton {
	
	private SimpleSingleton(){
		System.out.println("create singleton instance ");
	}
	
	private static SimpleSingleton instance = new SimpleSingleton();
	
	public static SimpleSingleton getInstance(){
		return instance;
	}
	
	/**
	 * 当调用此方法时会实例化单例 
	 */
	public static void createString(){
		System.out.println("create string ... ");
	}
	
	public static void main(String[] args) {
		SimpleSingleton.createString();
	}
}
