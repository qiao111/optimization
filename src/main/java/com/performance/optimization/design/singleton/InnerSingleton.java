package com.performance.optimization.design.singleton;

/**
 * 使用内部类实现单例,既可以做到延迟加载,也不必使用同步关键字,对多线程友好
 * @author qiaolin
 *
 */
public class InnerSingleton {
	
	private InnerSingleton(){
		System.out.println("create singleton implements by inner class ");
	}
	
	/**
	 * 采用内部类实现延迟加载,内部类天生对多线程友好
	 * @author qiaolin
	 *
	 */
	private static class InnerInstance{
		private static InnerSingleton instance = new InnerSingleton();
	}
	
	public static InnerSingleton getInstance(){
		return InnerInstance.instance;
	}
	
	/**
	 * 调用此方法不会对实例化单例对象
	 */
	public static void createString(){
		System.out.println("create string --inner class lazy singleton");
	}
	
	public static void main(String[] args) {
		InnerSingleton.createString();
	}
}
