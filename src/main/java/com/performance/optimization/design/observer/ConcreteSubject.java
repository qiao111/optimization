package com.performance.optimization.design.observer;

import java.util.Vector;

/**
 * 具体的主题实现 维护了观察者队列，提供了增加和删除观察者的方法并使用inform()通知观察者
 * @author qiaolin
 *
 */
public class ConcreteSubject implements ISubject{
	 
	private Vector<IObserver> observers = new Vector<IObserver>();
	
	public void attach(IObserver observer) {
		observers.add(observer);
	}

	public void detach(IObserver observer) {
		observers.remove(observer);
	}

	public void inform() {
		for(IObserver observer:observers){
			observer.update();//观察者的更新
		}
	}

}
