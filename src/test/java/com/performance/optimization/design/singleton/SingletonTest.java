package com.performance.optimization.design.singleton;

import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * 测试效率
 * @author qiaolin
 *
 */
public class SingletonTest {
	
	@Test
	public void testSimpleSingleton(){
		final long beginTime = System.currentTimeMillis();
		Executors.newCachedThreadPool().execute(new Runnable(){
			public void run() {
				for(long i = 0; i< 10000; i++){
					SynchronizedSingleton.getInstance();
				}
//					SimpleSingleton.getInstance();
				System.out.println("time:" + System.currentTimeMillis());
			}
		});
	}
}
