package com.performance.optimization.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * jdk自带的 具体主题
 * @author qiaolin
 *
 */
public class JdkSubject extends Observable{
	
	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
	}
	
	@Override
	public void notifyObservers(Object args) {
		super.setChanged();//状态发生改变
		super.notifyObservers(args);//通知所有观察者
	}
	
}
