package com.performance.optimization.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * jdk具体的观察者
 * @author qiaolin
 *
 */
public class JdkObserver implements Observer{
	
	
	public void update(Observable o, Object arg) {
		System.out.println("Jdk 自带的观察者通知消息");
	}

}
