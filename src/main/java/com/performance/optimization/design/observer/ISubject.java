package com.performance.optimization.design.observer;

public interface ISubject {
	//添加观察者
	void attach(IObserver observer);
	//删除观察者
	void detach(IObserver observer);
	//通知所有观察者
	void inform();
}