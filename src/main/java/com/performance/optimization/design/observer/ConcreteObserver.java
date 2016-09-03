package com.performance.optimization.design.observer;

/**
 * 具体的观察者
 * @author qiaolin
 *
 */
public class ConcreteObserver implements IObserver{

	public void update() {
		System.out.println("Observer receivers information");
	}
}
