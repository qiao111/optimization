package com.performance.optimization.design.observer;



import org.junit.Test;

/**
 * 观察者模式测试
 * @author qiaolin
 *
 */
public class ObserverTest {
	
	@Test
	public void test(){
		ConcreteSubject subject = new ConcreteSubject();
		subject.attach(new ConcreteObserver());//观察者加入
		subject.attach(new ConcreteObserver());//添加观察者
		
		subject.inform();//通知观察者
	}
	
	@Test
	public void testJDK(){
		JdkSubject subject = new JdkSubject();
		subject.addObserver(new JdkObserver());
		subject.addObserver(new JdkObserver());
		//通知所有观察者
		subject.notifyObservers(null);
	}
}
